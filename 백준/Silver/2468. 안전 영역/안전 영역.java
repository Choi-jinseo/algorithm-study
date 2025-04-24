import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int N;
    static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 1; // 잠기지 않은 구역
        for (int mask = 1; mask <= 100; mask++) { // 비의 양
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (mask < arr[i][j] && !visited[i][j]) { // 안잠김
                        dfs(i, j, mask);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
            for (int i = 0; i < N; i++) { // visited 초기화
                for (int j = 0; j < N; j++) {
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(max);
        br.close();
    }
    static void dfs(int i, int j, int mask) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (i + d[k][0] >= 0 && i + d[k][0] < N && j + d[k][1] >= 0 && j + d[k][1] < N) {
                if (arr[i + d[k][0]][j + d[k][1]] > mask && !visited[i + d[k][0]][j + d[k][1]]) {
                    dfs(i + d[k][0], j + d[k][1], mask);
                }
            }
        }
    }
}