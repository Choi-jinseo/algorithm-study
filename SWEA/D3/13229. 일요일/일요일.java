import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int answer = 0;
            if (str.equals("MON")) answer = 6;
            else if (str.equals("TUE")) answer = 5;
            else if (str.equals("WED")) answer = 4;
            else if (str.equals("THU")) answer = 3;
            else if (str.equals("FRI")) answer = 2;
            else if (str.equals("SAT")) answer = 1;
            else if (str.equals("SUN")) answer = 7;
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}