import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            char[] crr = new char[str.length()];
            for (int i = 0; i < crr.length; i++) {
                crr[i] = str.charAt(i);
            }
            int count = 0;
            for (int i = 0; i < crr.length; i++) {
                if (crr[i] == '.') continue;
                else if (crr[i] == '(') crr[i + 1] = ')';
                else if (crr[i] == ')') {
                    count++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}