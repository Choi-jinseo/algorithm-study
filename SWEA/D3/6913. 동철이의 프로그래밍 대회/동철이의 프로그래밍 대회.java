import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int max = 0; // 일등 수
            int cnt = 0; // 문제 수
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                if (sum > max) {
                    max = sum;
                    cnt = 1;
                }
                else if (sum == max) {
                    cnt++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(cnt).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}