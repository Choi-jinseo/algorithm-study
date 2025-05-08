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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            boolean ok = false;
            for (int X = R + 1; X <= L * 2; X++) {
                if (L % X >= (double) X/2 && R < X) {
                    ok = true;
                    break;
                }
            }
            if (ok) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}