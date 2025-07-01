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
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N-1; i++) {
                for (int j = 1; j < N-i; j++) {
                    if (arr[j-1] < arr[j]) {
                        int temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += arr[i];
            }
            sb.append("#").append(t + 1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}