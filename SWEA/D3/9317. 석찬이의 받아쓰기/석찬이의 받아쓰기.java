import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            int count = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) count++;
            }
            sb.append("#").append(t+1).append(" ").append(str1.length() - count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}