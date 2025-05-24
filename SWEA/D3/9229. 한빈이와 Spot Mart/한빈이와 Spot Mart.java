import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static int max;
    static int sum;
    static int min = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if (arr[i] + arr[j] > max && arr[i] + arr[j] <= M) {
                        max = arr[i] + arr[j];
                    }
                }
            }
            if (max == 0) max = -1;
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}