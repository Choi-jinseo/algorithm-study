import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            for (int i = 2; i < N-2; i++) {
                int min = 255;
                for (int j = 1; j <= 2; j++) {
                    min = Math.min(arr[i] - arr[i-j], min);
                }
                for (int j = 1; j <= 2; j++) {
                    min = Math.min(arr[i] - arr[i+j], min);
                }
                if (min > 0) answer += min;
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}