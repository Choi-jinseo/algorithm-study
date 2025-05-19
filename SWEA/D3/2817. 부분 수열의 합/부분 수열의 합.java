import java.io.*;
import java.util.*;

class Solution {
    static int K;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = 0;
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                dfs(arr, i, arr[i]);
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(int[] arr, int chkPoint, int sum) {
        if (sum == K) {
            count++;
            return;
        }
        for (int i = chkPoint + 1; i < arr.length; i++) {
            if (sum + arr[i] <= K) {
                dfs(arr, i, sum + arr[i]);
            }
        }
    }
}