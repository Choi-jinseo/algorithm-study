import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 부피
                arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
            }
            int[][] dp = new int[K+1][N];
            for (int i = 0; i < N; i++) {
                dp[0][i] = 0;
            }
            for (int i = 1; i <= K; i++) {
                if (arr[0][0] <= i) dp[i][0] = arr[0][1]; // 0번째 물건
            }
            for (int i = 1; i < N; i++) { // 물건 번호
                for (int j = 1; j <= K; j++) { // 배낭 무게
                    if (arr[i][0] <= j) dp[j][i] = Math.max(dp[j][i-1], arr[i][1] + dp[j - arr[i][0]][i-1]);
                    else dp[j][i] = dp[j][i-1];
                }
            }
            sb.append("#").append(t + 1).append(" ").append(dp[K][N-1]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
