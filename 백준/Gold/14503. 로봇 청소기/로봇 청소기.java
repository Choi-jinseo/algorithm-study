import java.io.*;
import java.util.*;

public class Main {
    static int[][] dr = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        // d) 0:북, 1:동, 2:남, 3:서

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while(true) {
            if (map[x][y] == 0) {
                map[x][y] = 2; // 청소 표시
                cnt++;
            }
            else { // 청소가 되어있는 칸이라면
                if (!find4d(x, y)) { // 4방향 모두 청소 불가능
                    // 후진
                    int td = (d + 2) % 4; // td: 후진 방향
                    int nx = x + dr[td][0];
                    int ny = y + dr[td][1];
                    if (!isIn(nx, ny) || map[nx][ny] == 1) break;
                    else {
                        x = nx;
                        y = ny;
                    }
                } else { // 4방향 중 청소 가능
                    while (true) {
                        d = (d + 3) % 4; // 반시계 90도 회전
                        int nx = x + dr[d][0];
                        int ny = y + dr[d][1];
                        if (isIn(nx, ny) && map[nx][ny] == 0) {
                            x = nx;
                            y = ny;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

        br.close();
    }
    static boolean find4d(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dr[i][0];
            int ny = y + dr[i][1];
            if(isIn(x, y) && map[nx][ny] == 0) return true; // 청소할 곳이 있음
        }
        return false;
    }
    static boolean isIn(int x, int y) {
        return 0<=x && x<N && 0<=y && y<M;
    }
}