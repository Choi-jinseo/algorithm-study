import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            double sum = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double p = Double.parseDouble(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                sum += p * x;
            }
            sb.append("#").append(t + 1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}