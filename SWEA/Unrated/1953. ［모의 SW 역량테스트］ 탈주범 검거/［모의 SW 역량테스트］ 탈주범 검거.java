import java.io.*;
import java.util.*;

public class Solution {
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
    static int N, M, R, C, L;
    static boolean[][][] map;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            // map 크기 입력
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            // 맨홀 위치
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            // 이동 시간
            L = Integer.parseInt(st.nextToken());

            map = new boolean[N][M][4];
            visited = new boolean[N][M];
            answer = 0;

            // map 내용 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int content = Integer.parseInt(st.nextToken());
                    switch (content) {
                        case 0:
                            break;
                        case 1: // 상하좌우
                            map[i][j][0] = map[i][j][1] = map[i][j][2] = map[i][j][3] = true;
                            break;
                        case 2: // 상하
                            map[i][j][0] = map[i][j][1] = true;
                            break;
                        case 3: // 좌우
                            map[i][j][2] = map[i][j][3] = true;
                            break;
                        case 4: // 상우
                            map[i][j][0] = map[i][j][3] = true;
                            break;
                        case 5: // 하우
                            map[i][j][1] = map[i][j][3] = true;
                            break;
                        case 6: // 하좌
                            map[i][j][1] = map[i][j][2] = true;
                            break;
                        case 7: // 상좌
                            map[i][j][0] = map[i][j][2] = true;
                            break;
                    }
                }
            }
            bfs();
            sb.append("#").append(t).append(" ").append(answer).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{R,C,L});
        visited[R][C] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            answer++;
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            if (cnt > 1) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + d[i][0];
                    int ny = y + d[i][1];
                    if (isIn(nx, ny) && !visited[nx][ny] && map[x][y][i] && map[nx][ny][i < 2 ? (i + 1) % 2 : (i + 1) % 2 + 2]) {
                        queue.add(new int[]{nx, ny, cnt - 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    static boolean isIn(int x, int y) {
        return 0<=x && x<N && 0<=y && y<M;
    }
}
