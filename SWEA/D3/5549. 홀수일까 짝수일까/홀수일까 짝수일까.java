import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            sb.append("#").append(t + 1).append(" ");
            if ((str.charAt(str.length()-1) - '0') % 2 == 1) sb.append("Odd");
            else sb.append("Even");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}