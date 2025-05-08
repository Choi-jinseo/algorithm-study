import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String S = br.readLine();
            String E = br.readLine();
            boolean reverse = false;
            int left = 0;
            int right = E.length() - 1;
            for (int i = 0; i < E.length() - S.length(); i++) {
                if (!reverse) {
                    if (E.charAt(right) == 'Y') reverse = true;
                    right--;
                }
                else {
                    if (E.charAt(left) == 'Y') reverse = false;
                    left++;
                }
            }
            boolean flag = true;
            if (!reverse) {
                for (int i = left; i <= right; i++) {
                    if (E.charAt(i) != S.charAt(i-left)) {
                        flag = false;
                        break;
                    }
                }
            }
            else {
                for (int i = right; i >= left; i--) {
                    if (E.charAt(i) != S.charAt(right-i)) {
                        flag = false;
                        break;
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ");
            if (flag) sb.append("Yes\n");
            else sb.append("No\n");
        }
        System.out.print(sb);
        br.close();
    }
}