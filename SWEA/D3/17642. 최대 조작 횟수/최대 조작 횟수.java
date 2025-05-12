import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long dist = B - A;
            sb.append("#").append(t+1).append(" ");
            if (dist == 1 || dist < 0) sb.append(-1);
            else sb.append(dist / 2);
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}