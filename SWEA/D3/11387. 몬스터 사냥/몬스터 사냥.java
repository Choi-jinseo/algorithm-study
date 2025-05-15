import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int n = 0; n < N; n++) {
                sum += (D + (D / 100) * n * L);
            }
            sb.append("#").append(t + 1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}