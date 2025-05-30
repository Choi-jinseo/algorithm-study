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
            int Q = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for (int i = 1; i <= Q; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken())-1;
                int R = Integer.parseInt(st.nextToken())-1;
                for (int j = L; j <= R; j++) {
                    arr[j] = i;
                }
            }
            sb.append("#").append(t+1);
            for (int i = 0; i < N; i++) {
                sb.append(" ").append(arr[i]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}