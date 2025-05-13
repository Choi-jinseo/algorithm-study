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
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == '#') {
                        for (int k = 0; k < N; k++) {
                            for (int l = 0; l < M; l++) {
                                if ((k + l) % 2 == (i + j) % 2) {
                                    if (arr[k][l] == '.') {
                                        flag = true;
                                        break;
                                    }
                                }
                                else {
                                    if (arr[k][l] == '#') {
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                            if (flag) break;
                        }
                        break;
                    }
                    else if (arr[i][j] == '.') {
                        for (int k = 0; k < N; k++) {
                            for (int l = 0; l < M; l++) {
                                if ((k + l) % 2 == (i + j) % 2) {
                                    if (arr[k][l] == '#') {
                                        flag = true;
                                        break;
                                    }
                                }
                                else {
                                    if (arr[k][l] == '.') {
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                            if (flag) break;
                        }
                        break;
                    }
                }
            }
            sb.append("#").append(t+1).append(" ");
            if (!flag) sb.append("possible");
            else sb.append("impossible");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}