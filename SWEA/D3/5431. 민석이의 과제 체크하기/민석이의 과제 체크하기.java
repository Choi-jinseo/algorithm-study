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
            int[] arr = new int[N];
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                arr[Integer.parseInt(st.nextToken())-1] = 1;
            }
            sb.append("#").append(t + 1);
            for (int i = 0; i < N; i++) {
                if (arr[i] == 0) sb.append(" ").append(i + 1);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}