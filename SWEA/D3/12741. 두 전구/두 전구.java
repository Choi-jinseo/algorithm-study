import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int start = Math.max(A, C);
            int end = Math.min(B, D);
            int answer = end - start;
            if (answer < 0) answer = 0;
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}