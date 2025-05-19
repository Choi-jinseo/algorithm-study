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
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[11112];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
            if (arr[0] != 0) {
                sb.append("#").append(t+1).append(" ").append("Impossible").append('\n');
                continue;
            }
            int bread = 0;
            boolean flag = false;
            for (int i = 1; i < 11112; i++) { // 시간
                if (i % M == 0) bread += K; // 생산 빵

                bread -= arr[i];
                if (bread < 0) {
                    flag = true;
                    break;
                }
            }
            sb.append("#").append(t+1).append(" ");
            if (!flag) sb.append("Possible");
            else sb.append("Impossible");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}