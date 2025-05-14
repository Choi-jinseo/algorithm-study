import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int M = D * 2 + 1;
            sb.append("#").append(t+1).append(" ");
            for (int i = 1; i <= N; i++) {
                if (M < N) M += (D * 2 + 1);
                else {
                    sb.append(i).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}