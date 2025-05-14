import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] arr = new boolean[N][N];
            int count = 0;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) == '#';
                    if (str.charAt(j) == '#') count++;
                }
            }
            boolean flag = false;
            for (int i = 1; i <= 20; i++) {
                if (Math.pow(i, 2) == count) {
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append("#").append(t + 1).append(" ").append("no").append('\n');
            else {
                flag = false;
                boolean checked = false;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j]) {
                            checked = true;
                            if (Math.max(i, j) + Math.sqrt(count) > N) flag = true;
                            else {
                                for (int k = i; k < i + Math.sqrt(count); k++) {
                                    for (int l = j; l < j + Math.sqrt(count); l++) {
                                        if (!arr[k][l]) {
                                            flag = true;
                                            break;
                                        }
                                    }
                                    if (flag) break;
                                }
                            }
                            break;
                        }
                    }
                    if (checked) break;
                }
                if (flag) sb.append("#").append(t + 1).append(" ").append("no").append('\n');
                else sb.append("#").append(t + 1).append(" ").append("yes").append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}