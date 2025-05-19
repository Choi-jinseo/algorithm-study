import java.io.*;
import java.util.*;

class Solution {
    static int[][] d = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
            {-1,-1},
            {1,1},
            {-1,1},
            {1,-1}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            arr[N / 2 - 1][N / 2 - 1] = 2;
            arr[N / 2 - 1][N / 2] = 1;
            arr[N / 2][N / 2 - 1] = 1;
            arr[N / 2][N / 2] = 2;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x0 = Integer.parseInt(st.nextToken()) - 1;
                int y0 = Integer.parseInt(st.nextToken()) - 1;
                arr[x0][y0] = Integer.parseInt(st.nextToken());
                // 8방 탐색
                for (int j = 0; j < 8; j++) {
                    int x1 = x0 + d[j][0];
                    int y1 = y0 + d[j][1];
                    int x2 = x1 + d[j][0];
                    int y2 = y1 + d[j][1];
                    if (x2 >= 0 && x2 < N && y2 >= 0 && y2 < N && arr[x1][y1] != arr[x0][y0] && arr[x1][y1] != 0) {
                        int count = 0;
                        boolean change = false;
                        for (int xt = x1, yt = y1; xt >= 0 && xt < N && yt >= 0 && yt < N; xt += d[j][0], yt += d[j][1]) {
                            if (arr[xt][yt] == arr[x1][y1]) count++;
                            else if (arr[xt][yt] == arr[x0][y0]) {
                                change = true;
                                break;
                            }
                            else break;
                        }
                        if (change) {
                            for (int xt = x1, yt = y1; count > 0; xt += d[j][0], yt += d[j][1]) {
                                arr[xt][yt] = arr[x0][y0];
                                count--;
                            }
                        }
                    }
                }
            }
            int BN = 0;
            int WN = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) BN++;
                    else if (arr[i][j] == 2) WN++;
                }
            }
            sb.append("#").append(t+1).append(" ").append(BN).append(" ").append(WN).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}