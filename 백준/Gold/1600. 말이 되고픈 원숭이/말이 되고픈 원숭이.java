import java.io.*;
import java.util.*;

public class Main {
    static int[][] md = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 원숭이의 이동 (4방향)
    static int[][] hd = {{-2,-1}, {-2,1}, {2,-1}, {2,1}, {-1,-2}, {1,-2}, {-1,2}, {1,2}}; // 말의 이동 (8방향)
    static int K, W, H;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine()); // 말의 호흡 가능 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 격자판 너비
        H = Integer.parseInt(st.nextToken()); // 격자판 높이
        min = Integer.MAX_VALUE;

        boolean[][] map = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                // true : 이동가능, false : 장애물
                map[i][j] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k <= K; k++) {
                    visited[i][j][k] = map[i][j];
                }
            }
        }

        queue.add(new int[] {0,0,0,0}); // 좌표, 말의 호흡 횟수, 이동횟수

        for (int k = 0; k <= K; k++) {
            visited[0][0][k] = true;
        }
        boolean flag = false;

        // bfs
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int use = cur[2];
            int move = cur[3];
            // 말의 이동
            if (use < K) { // 아직 말의 호흡 가능
                for (int i = 0; i < hd.length; i++) {
                    int nx = x + hd[i][0];
                    int ny = y + hd[i][1];
                    if (nx == H-1 && ny == W-1) {
                        flag = true;
                        break;
                    }
                    if (0<=nx && nx<H && 0<=ny && ny<W && !visited[nx][ny][use+1]) {
                        queue.add(new int[] {nx,ny,use+1,move+1});
                        visited[nx][ny][use+1] = true;
                    }
                }
            }
            // 원숭이의 이동
            for (int i = 0; i < md.length; i++) {
                int nx = x + md[i][0];
                int ny = y + md[i][1];
                if (nx == H-1 && ny == W-1) {
                    flag = true;
                    break;
                }
                if (0<=nx && nx<H && 0<=ny && ny<W && !visited[nx][ny][use]) {
                    queue.add(new int[] {nx,ny,use,move+1});
                    visited[nx][ny][use] = true;
                }
            }
            if (flag) {
                min = Math.min(min, move + 1);
                break;
            }
        }
        if (min == Integer.MAX_VALUE) {
            if (H == 1 && W == 1) System.out.println(0);
            else System.out.println(-1);
        }
        else System.out.println(min);
        br.close();
    }
}