import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    sb.append((char)(str.charAt(i) - 'a' + 'A'));
                } else sb.append(str.charAt(i));
            }
        }
        System.out.print(sb);
        br.close();
    }
}