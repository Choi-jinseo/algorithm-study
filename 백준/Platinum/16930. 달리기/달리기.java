import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 한번에 이동할수있는 거리
		
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		// 출발지
		int x1 = Integer.parseInt(st.nextToken())-1;
		int y1 = Integer.parseInt(st.nextToken())-1;
		// 도착지
		int x2 = Integer.parseInt(st.nextToken())-1;
		int y2 = Integer.parseInt(st.nextToken())-1;
		
		int[][] value = new int[N][M]; // -1
		int[][] direction = new int[N][M]; // -1
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				value[i][j] = -1;
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x1,y1});
		value[x1][y1] = 0;
		
		while (!queue.isEmpty()) {
			
			int[] node = queue.poll();
			int x = node[0];
			int y = node[1];
			int v = value[x][y];
			
			for (int i = x-1; i >= x-K && i >= 0; i--) { // 상
				if (map[i][y] == '#' || value[i][y] == v) break;
				if (value[i][y] != -1) continue;
				queue.add(new int[] {i,y});
				value[i][y] = v+1;
			}
			for (int i = x+1; i <= x+K && i < N; i++) { // 하
				if (map[i][y] == '#' || value[i][y] == v) break;
				if (value[i][y] != -1) continue;
				queue.add(new int[] {i,y});
				value[i][y] = v+1;
			}
			for (int i = y-1; i >= y-K && i >= 0; i--) { // 좌
				if (map[x][i] == '#' || value[x][i] == v) break;
				if (value[x][i] == -1) {
					queue.add(new int[] {x,i});
					value[x][i] = v+1;
				}
			}
			for (int i = y+1; i <= y+K && i < M; i++) { // 우
				if (map[x][i] == '#' || value[x][i] == v) break;
				if (value[x][i] != -1) continue;
				queue.add(new int[] {x,i});
				value[x][i] = v+1;
			}
		}
		
		System.out.println(value[x2][y2]);
		
		
		br.close();
	}
}
