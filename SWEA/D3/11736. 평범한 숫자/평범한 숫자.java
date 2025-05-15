import java.io.*;
import java.util.*;

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
            int count = 0;
            for (int i = 1; i < N-1; i++) {
                int min = Math.min(arr[i - 1], Math.min(arr[i], arr[i + 1]));
                int max = Math.max(arr[i - 1], Math.max(arr[i], arr[i + 1]));
                if (arr[i] != min && arr[i] != max) count++;
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}