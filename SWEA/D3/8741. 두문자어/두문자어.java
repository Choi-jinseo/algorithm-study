import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();
            char A = (char)(a.charAt(0)-'a'+'A');
            char B = (char)(b.charAt(0)-'a'+'A');
            char C = (char)(c.charAt(0)-'a'+'A');
            sb.append("#").append(t + 1).append(" ").append(A).append(B).append(C).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}