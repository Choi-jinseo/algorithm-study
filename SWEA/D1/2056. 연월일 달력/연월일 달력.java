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
            String str = br.readLine();
            boolean flag = true;
            int year = Integer.parseInt("" + str.charAt(0) + str.charAt(1) + str.charAt(2) + str.charAt(3));
            if (year == 0) flag = false;
            int month = Integer.parseInt("" + str.charAt(4) + str.charAt(5));
            if (month > 12 || month == 0) {
                flag = false;
            }
            int day = Integer.parseInt("" + str.charAt(6) + str.charAt(7));
            if (flag) {
                if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 31 || day == 0) flag = false;
                }
                else if (month == 2) {
                    if (day > 28 || day == 0) flag = false;
                }
                else {
                    if (day > 30 || day == 0) flag = false;
                }
            }
            sb.append("#").append(t + 1).append(" ");
            if (flag) {
                for (int i = 0; i < 4; i++) {
                    sb.append(str.charAt(i));
                }
                sb.append('/');
                for (int i = 4; i < 6; i++) {
                    sb.append(str.charAt(i));
                }
                sb.append('/');
                for (int i = 6; i < 8; i++) {
                    sb.append(str.charAt(i));
                }
                sb.append('\n');
            }
            else sb.append(-1).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}