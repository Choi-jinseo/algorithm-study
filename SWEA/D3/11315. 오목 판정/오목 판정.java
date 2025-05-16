import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            boolean yes = false;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) == 'o' ? 1 : 0;
                }
            }
            // 가로줄 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 4; j++) {
                    boolean flag = false;
                    for (int k = j; k < j + 5; k++) {
                        if (arr[i][k] != 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        yes = true;
                        break;
                    }
                }
                if (yes) break;
            }
            // 세로줄 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 4; j++) {
                    boolean flag = false;
                    for (int k = j; k < j + 5; k++) {
                        if (arr[k][i] != 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        yes = true;
                        break;
                    }
                }
                if (yes) break;
            }
            // 대각선 확인 '\'
            for (int i = 0; i < N - 4; i++) {
                for (int j = 0; j < N - 4; j++) {
                    boolean flag = false;
                    for (int k = 0; k < 5; k++) {
                        if (arr[i+k][j+k] != 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        yes = true;
                        break;
                    }
                }
                if (yes) break;
            }
            // 대각선 확인 '/'
            for (int i = 0; i < N - 4; i++) {
                for (int j = 4; j < N; j++) {
                    boolean flag = false;
                    for (int k = 0; k < 5; k++) {
                        if (arr[i+k][j-k] != 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        yes = true;
                        break;
                    }
                }
                if (yes) break;
            }
            if (yes) sb.append("#").append(t + 1).append(" ").append("YES").append('\n');
            else sb.append("#").append(t + 1).append(" ").append("NO").append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}