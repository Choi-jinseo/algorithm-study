import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp 0행 완성하기
        dp[0][0] = arr[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        for (int i = 1; i < N; i++) {
            int[] maxLToR = new int[M];
            int[] maxRToL = new int[M];
            for (int j = 0; j < M; j++) { // 수직선
                maxLToR[j] = dp[i - 1][j] + arr[i][j];
                maxRToL[j] = dp[i - 1][j] + arr[i][j];
            }
            for (int j = 1; j < M; j++) { // 니은
                maxLToR[j] = Math.max(maxLToR[j-1] + arr[i][j], maxLToR[j]); // max(니은, 수직선)
            }
            for (int j = M-2; j >= 0; j--) { // 반니은
                maxRToL[j] = Math.max(maxRToL[j+1] + arr[i][j], maxRToL[j]); // max(반니은, 수직선)
            }
            for (int j = 0; j < M; j++) { // 니은 반니은 중 최대 경로로 저장
                dp[i][j] = Math.max(maxLToR[j], maxRToL[j]);
            }
        }
        System.out.println(dp[N-1][M-1]);

        br.close();
    }
}