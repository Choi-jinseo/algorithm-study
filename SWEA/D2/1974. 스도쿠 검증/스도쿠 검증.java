import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean flag = false;
            for (int i = 0; i < 9; i++) {
                int[] nine = new int[9];
                for (int j = 0; j < 9; j++) {
                    nine[arr[i][j]-1]++;
                }
                for (int j = 0; j < 9; j++) {
                    if (nine[j] != 1) {
                        flag = true;
                        break;
                    }
                }
            }
            for (int j = 0; j < 9; j++) {
                int[] nine = new int[9];
                for (int i = 0; i < 9; i++) {
                    nine[arr[i][j]-1]++;
                }
                for (int i = 0; i < 9; i++) {
                    if (nine[i] != 1) {
                        flag = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                int[] nine = new int[9];
                for (int j = (i / 3) * 3; j < (i / 3) * 3 + 3; j++) {
                    for (int k = (i % 3) * 3; k < (i % 3) * 3 + 3; k++) {
                        nine[arr[j][k]-1]++;
                    }
                }
                for (int j = 0; j < 9; j++) {
                    if (nine[j] != 1) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) sb.append("#").append(t + 1).append(" ").append(1).append('\n');
            else sb.append("#").append(t + 1).append(" ").append(0).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
