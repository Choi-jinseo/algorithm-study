import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int sum = 0;
            int px = 0;
            int py = 0;
            int qx = 0;
            int qy = 0;
            for (int i = 1; sum <= 10000; i++) { // i 번째 대각선
                if (sum < p && p <= sum + i) {
                    px = p - sum;
                    py = i + 1 - px;
                    break;
                }
                sum += i;
            }
            sum = 0;
            for (int i = 1; sum <= 10000; i++) { // i 번째 대각선
                if (sum < q && q <= sum + i) {
                    qx = q - sum;
                    qy = i + 1 - qx;
                    break;
                }
                sum += i;
            }
            int rx = px + qx;
            int ry = py + qy;
            sum = 0;
            for (int i = 1; i + 1 < rx + ry; i++) { // i 번째 대각선
                sum += i;
            }
            sb.append("#").append(t + 1).append(" ").append(sum + rx).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}