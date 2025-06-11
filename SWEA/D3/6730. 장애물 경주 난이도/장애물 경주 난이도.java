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
            int answer1 = 0;
            int answer2 = 0;
            for (int i = 1; i < N; i++) {
                if (arr[i-1] < arr[i]) {
                    answer1 = Math.max(arr[i] - arr[i-1], answer1);
                } else {
                    answer2 = Math.max(arr[i-1] - arr[i], answer2);
                }
            }
            sb.append("#").append(t+1).append(" ").append(answer1).append(" ").append(answer2).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}