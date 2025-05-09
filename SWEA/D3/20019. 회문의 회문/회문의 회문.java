import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            boolean flag = false;
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int i = 0; i < str.length() / 4; i++) {
                    if (str.charAt(i) != str.charAt(str.length() / 2 - 1 - i)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                for (int i = str.length() / 2 + 1; i < (str.length() - (str.length() / 2 + 1)) / 2; i++) {
                    if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) sb.append("#").append(t + 1).append(" NO\n");
            else sb.append("#").append(t + 1).append(" YES\n");
        }
        System.out.print(sb);
        br.close();
    }
}