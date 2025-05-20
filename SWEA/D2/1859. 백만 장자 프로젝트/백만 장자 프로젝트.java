import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = arr[N-1];
            long sum = 0;
            for (int i = N-2; i >= 0; i--) {
                if (arr[i] < max) sum += (max - arr[i]);
                else max = arr[i];
            }
            sb.append("#").append(t+1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
