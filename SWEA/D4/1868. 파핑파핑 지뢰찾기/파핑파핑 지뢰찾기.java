import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] d8 = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 초기화
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            // 칸에 들어갈 수 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == '.') {
                        char bomb = '0';
                        for (int k = 0; k < 8; k++) {
                            int x = i+d8[k][0];
                            int y = j+d8[k][1];
                            // 범위 체크
                            if (x >= 0 && x < N && y >= 0 && y < N) {
                                if (arr[x][y] == '*') bomb++;
                            }
                        }
                        arr[i][j] = bomb;
                    }
                    else { // '*'
                        visited[i][j] = true;
                    }
                }
            }
            int cnt = 0;
            // 1. 확장가능 영역 수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == '0' && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            // 2. 독립적인 한 칸의 수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) cnt++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(cnt).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void bfs(int i, int j) {
        visited[i][j] = true;
        // 8방 탐색
        for (int k = 0; k < 8; k++) {
            int x = i+d8[k][0];
            int y = j+d8[k][1];
            // 범위, 방문 체크
            if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                // 0이 아니면 방문 표시
                // 0이면 그곳에 대해 8방탐색(bfs)
                if (arr[x][y] != '0') visited[x][y] = true;
                else bfs(x, y);
            }
        }
    }
}