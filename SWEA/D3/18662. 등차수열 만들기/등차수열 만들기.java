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
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int x1 = three - two;
            x1 = Math.abs(two - x1 - one);
            double x2 = (double)(one + three) / 2;
            x2 = Math.abs(two - x2);
            int x3 = two - one;
            x3 = Math.abs(two + x3 - three);
            double answer = Math.min(Math.min(x1, x2), x3);
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}