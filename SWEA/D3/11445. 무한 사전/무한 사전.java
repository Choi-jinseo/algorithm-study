import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String P = br.readLine();
            String Q = br.readLine();
            if (P.length() >= Q.length()) sb.append("#").append(t + 1).append(" ").append('Y').append('\n');
            else {
                boolean flag = false;
                for (int i = 0; i < P.length(); i++) {
                    if (P.charAt(i) != Q.charAt(i)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) sb.append("#").append(t + 1).append(" ").append('Y').append('\n');
                else {
                    if (Q.length() - P.length() == 1 && Q.charAt(Q.length()-1) == 'a') sb.append("#").append(t + 1).append(" ").append('N').append('\n');
                    else sb.append("#").append(t + 1).append(" ").append('Y').append('\n');
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}