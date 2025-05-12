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
            long num;
            for (long i = (int)Math.sqrt(N); i > 0; i--) {
                if (N % i == 0) {
                    sb.append("#").append(t + 1).append(" ").append(i + N / i - 2).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}