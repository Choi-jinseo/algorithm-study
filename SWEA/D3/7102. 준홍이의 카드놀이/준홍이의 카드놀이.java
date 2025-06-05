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
            int[] arr = new int[N];
            int[] brr = new int[M];
            int[] crr = new int[N+M+1];
            for (int i = 0; i < N; i++) {
                arr[i] = i+1;
            }
            for (int i = 0; i < M; i++) {
                brr[i] = i+1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    crr[arr[i] + brr[j]]++;
                }
            }
            int max = 0;
            for (int i = 0; i < crr.length; i++) {
                if (crr[i] > max) max = crr[i];
            }
            sb.append("#").append(t + 1);
            for (int i = 0; i < crr.length; i++) {
                if (crr[i] == max) sb.append(" ").append(i);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}