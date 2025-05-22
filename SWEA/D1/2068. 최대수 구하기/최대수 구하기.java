import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) max = num;
            }
            sb.append("#").append(t+1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}