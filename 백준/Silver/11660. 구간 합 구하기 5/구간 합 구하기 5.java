import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		int[][] sum = new int[N+1][N+1]; // 누적합 배열
		// 안쓰는 0번째 부분 0으로 초기화
		for (int i = 0; i < N+1; i++) {
			sum[i][0] = 0;
			sum[0][i] = 0;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				// 현재 값 + i줄 한줄에 대해 j-1까지의 누적합 + j줄에서 이전까지의 누적합 
				sum[i][j] = Integer.parseInt(st.nextToken()) + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]; 
			}
		}
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int answer = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
			sb.append(answer).append('\n'); // 누적합 끼리 빼는 방법으로 사이합을 구한다.
		}
		System.out.println(sb);
	}
}
