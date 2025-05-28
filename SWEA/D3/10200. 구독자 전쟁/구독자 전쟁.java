import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int min = 0;
            int max = 0;
            max = Math.min(A, B);
            if (A + B > N) min = A + B - N;

            sb.append("#").append(t + 1).append(" ").append(max).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}