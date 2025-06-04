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
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}