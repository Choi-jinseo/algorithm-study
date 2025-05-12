import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            sb.append("#").append(t+1).append(" ");
            boolean flag = false;
            if (N % 2 == 1) flag = true;
            else {
                for (int i = 0, j = N / 2; j < N; i++, j++) {
                    if (str.charAt(i) != str.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) sb.append("Yes");
            else sb.append("No");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}