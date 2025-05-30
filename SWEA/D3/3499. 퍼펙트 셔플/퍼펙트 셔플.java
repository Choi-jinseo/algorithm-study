import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }
            sb.append("#").append(t+1).append(" ");
            if (N == 1) sb.append(arr[0]);
            else if (N % 2 == 0) {
                for (int i = 0; i < N / 2; i++) {
                    sb.append(arr[i]).append(" ").append(arr[N / 2 + i]).append(" ");
                }
            }
            else {
                for (int i = 0; i < N / 2; i++) {
                    sb.append(arr[i]).append(" ").append(arr[(N+1)/2 + i]).append(" ");
                }
                sb.append(arr[N/2]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}