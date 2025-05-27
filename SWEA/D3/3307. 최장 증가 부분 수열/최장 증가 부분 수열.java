import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dp[N-1] = 1; // 맨 마지막 수만 가지고 만든 수열의 크기
            for (int i = N-2; i >= 0; i--) {
                int max = 0;
                for (int j = i+1; j < N; j++) {
                    if (arr[i] < arr[j]) {
                        if (dp[j] > max) {
                            max = dp[j];
                        }
                    }
                }
                dp[i] = max + 1;
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (max < dp[i]) max = dp[i];
            }
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}