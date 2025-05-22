import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            int i = 0;
            while (Math.max(x, y) <= N) {
                if (x <= y) x += y;
                else y += x;
                i++;
            }
            sb.append(i).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}