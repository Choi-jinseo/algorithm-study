import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                hs.add(str.charAt(i));
            }
            sb.append("#").append(t + 1).append(" ").append(hs.size()).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}