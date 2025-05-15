import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int a = 1;
            int b = 1;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'L') {
                    b = a + b;
                }
                else {
                    a = a + b;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(a).append(" ").append(b).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}