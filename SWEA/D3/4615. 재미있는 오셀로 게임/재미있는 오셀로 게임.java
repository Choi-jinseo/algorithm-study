import java.io.*;
import java.util.*;

class Solution {
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
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                arr[x][y] = Integer.parseInt(st.nextToken());
                // 8방 탐색
                // 상하
                if (x > 1 && arr[x-1][y] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; x-d >= 0; d++) {
                        if (arr[x-d][y] == 0) break;
                        else if (arr[x-d][y] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x-d][y] = arr[x][y];
                    }
                }
                if (x < N - 2 && arr[x+1][y] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; x+d < N; d++) {
                        if (arr[x+d][y] == 0) break;
                        else if (arr[x+d][y] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x+d][y] = arr[x][y];
                    }
                }
                // 좌우
                if (y > 1 && arr[x][y-1] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; y-d >= 0; d++) {
                        if (arr[x][y-d] == 0) break;
                        else if (arr[x][y-d] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x][y-d] = arr[x][y];
                    }
                }
                if (y < N - 2 && arr[x][y+1] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; y+d < N; d++) {
                        if (arr[x][y+d] == 0) break;
                        else if (arr[x][y+d] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x][y+d] = arr[x][y];
                    }
                }
                // \
                if (x > 1 && y > 1 && arr[x-1][y-1] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; x-d >= 0 && y-d >= 0; d++) {
                        if (arr[x-d][y-d] == 0) break;
                        else if (arr[x-d][y-d] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x-d][y-d] = arr[x][y];
                    }
                }
                if (x < N - 2 && y < N - 2 && arr[x+1][y+1] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; x+d < N && y+d < N; d++) {
                        if (arr[x+d][y+d] == 0) break;
                        else if (arr[x+d][y+d] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x+d][y+d] = arr[x][y];
                    }
                }
                // /
                if (x > 1 && y < N - 2 && arr[x-1][y+1] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; x-d >= 0 && y+d < N; d++) {
                        if (arr[x-d][y+d] == 0) break;
                        else if (arr[x-d][y+d] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x-d][y+d] = arr[x][y];
                    }
                }
                if (x < N - 2 && y > 1 && arr[x+1][y-1] != arr[x][y]) {
                    int count = 0;
                    boolean flag = false;
                    for (int d = 1; x+d < N && y-d >= 0; d++) {
                        if (arr[x+d][y-d] == 0) break;
                        else if (arr[x+d][y-d] == arr[x][y]) {
                            flag = true; // 변경 조건
                            break;
                        }
                        else count++;
                    }
                    if (flag) for (int d = 1; d < 1 + count; d++) {
                        arr[x+d][y-d] = arr[x][y];
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