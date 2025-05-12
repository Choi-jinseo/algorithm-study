import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            // N -> i * j
            long min = N + 1; // N -> N * 1
            for (long i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    long j = N / i;
                    if (i + j < min) min = i + j;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(min - 2).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}