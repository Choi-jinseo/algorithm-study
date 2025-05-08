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
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int floor = 0;
            for (int i = 1; i <= N; i++) {
                if (floor + i == P) floor--;
                floor += i;
            }
            sb.append(floor).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}