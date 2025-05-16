import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int pow = x * x + y * y;
                if (pow == 0) {
                    sum += 10;
                    continue;
                }
                for (int j = 20; j <= 200; j+=20) {
                    if ((j-20) * (j-20) < pow && pow <= j * j) {
                        sum += (11 - j / 20);
                        break;
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}