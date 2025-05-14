import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int loseCnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'x') loseCnt++;
            }
            if (loseCnt >= 8) sb.append("#").append(t + 1).append(" ").append("NO").append('\n');
            else sb.append("#").append(t + 1).append(" ").append("YES").append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}