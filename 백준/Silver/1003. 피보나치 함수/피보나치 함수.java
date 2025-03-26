import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            if (N > 0) {
                dp[1][0] = 0;
                dp[1][1] = 1;
            }
            for (int j = 2; j <= N; j++) {
                dp[j][0] = dp[j-1][0] + dp[j-2][0];
                dp[j][1] = dp[j-1][1] + dp[j-2][1];
            }
            sb.append(dp[N][0]).append(' ').append(dp[N][1]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}
