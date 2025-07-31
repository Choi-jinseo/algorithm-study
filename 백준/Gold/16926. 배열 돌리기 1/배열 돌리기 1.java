import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 껍데기 수
		int max = Math.min(N, M) / 2;
		int idx = 0; // 껍데기 번호 (바깥부터 0)
		while (idx < max) { // 모든 껍데기에 대해
			// 껍데기 이동 순서 : 동, 남, 서, 북
			int[] shell = new int[(2*(N+M)-4-8*idx)*2]; // 껍데기 내부 원소 정보. 2번 저장했음
			int cnt = 0; // 껍데기 내부 인덱스
			for(int i = idx; i < M-idx; i++) {
				shell[cnt++] = map[idx][i];
			}
			for(int j = idx+1; j < N-idx; j++) {
				shell[cnt++] = map[j][M-1-idx];
			}
			for(int i = M-2-idx; i >= idx; i--) {
				shell[cnt++] = map[N-1-idx][i];
			}
			for(int j = N-2-idx; j > idx; j--) {
				shell[cnt++] = map[j][idx];
			}
			
			for(int i = cnt, j = 0; i < shell.length; i++, j++) {
				shell[i] = shell[j];
			}
			cnt = R%cnt;
			
			for(int i = idx; i < M-idx; i++) {
				map[idx][i] = shell[cnt++];
			}
			for(int j = idx+1; j < N-idx; j++) {
				map[j][M-1-idx] = shell[cnt++];
			}
			for(int i = M-2-idx; i >= idx; i--) {
				map[N-1-idx][i] = shell[cnt++];
			}
			for(int j = N-2-idx; j > idx; j--) {
				map[j][idx] = shell[cnt++];
			}
			idx++;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
