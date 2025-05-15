import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            int PD = Integer.parseInt(st.nextToken());
            int PG = Integer.parseInt(st.nextToken());
            sb.append("#").append(t+1).append(" ");
            if (PG == 0 && PD != 0 || PG == 100 && PD != 100) {
                sb.append("Broken");
            }
            else {
                int minD = 0;
                for (int i = PD; i > 0; i--) {
                    if (100 % i == 0 && PD % i == 0) { // 둘 다 나누어 떨어지면
                        minD = 100 / i;
                        break;
                    }
                }
                if (minD <= N) sb.append("Possible");
                else sb.append("Broken");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}