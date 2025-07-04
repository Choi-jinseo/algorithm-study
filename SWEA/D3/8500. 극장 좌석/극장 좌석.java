import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            int sum = max + N;
            for (int i = 0; i < N; i++) {
                sum += arr[i];
            }
            sb.append("#").append(t + 1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}