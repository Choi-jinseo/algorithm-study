import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] DP = new int[1000001];
        DP[0] = 0;
        DP[1] = 0;
        for (int i = 2; i <= N; i++) {
            int min = 1000001;
            // 6의 배수일때
            if (i % 6 == 0) {
                DP[i] = min(DP[i/3], DP[i/2], DP[i-1]) + 1;
            }
            else {
                // 3의 배수
                if (i % 3 == 0) DP[i] = min(DP[i/3], DP[i-1]) + 1;
                // 2의 배수
                else if (i % 2 == 0) DP[i] = min(DP[i/2], DP[i-1]) + 1;
                // 둘 다 아닐때
                else DP[i] = DP[i-1] + 1;
            }
        }
        System.out.println(DP[N]);
    }
    private static int min(int x, int y, int z) {
        int min;
        min = (x < y ? x : y);
        min = (min < z ? min : z);
        return min;
    }
    private static int min(int x, int y) {
        int min;
        min = (x < y ? x : y);
        return min;
    }
}