import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;
            // 가로선 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N-K; j++) {
                    if (arr[i][j] == 1) {
                        int count = 0;
                        for (int k = j; k < N; k++) {
                            if (arr[i][k] == 0) break;
                            else count++;
                        }
                        if (count == K) answer++;
                        if (j + count == N) break;
                        else j += (count - 1);
                    }
                }
            }
            // 세로선 탐색
            for (int j = 0; j < N; j++) {
                for (int i = 0; i <= N-K; i++) {
                    if (arr[i][j] == 1) {
                        int count = 0;
                        for (int k = i; k < N; k++) {
                            if (arr[k][j] == 0) {
                                break;
                            }
                            else count++;
                        }
                        if (count == K) answer++;
                        if (i + count == N) break;
                        else i += (count - 1);
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
