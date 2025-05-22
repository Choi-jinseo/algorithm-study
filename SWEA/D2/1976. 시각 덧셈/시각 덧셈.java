import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int H = (h1 + h2 - 1) % 12 + 1;
            int M = m1 + m2;
            if (M >= 60) {
                H = H % 12 + 1;
                M -= 60;
            }
            sb.append("#").append(t + 1).append(" ").append(H).append(" ").append(M).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}