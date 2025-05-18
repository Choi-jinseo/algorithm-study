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
            int[] brr = new int[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
                brr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if ((arr[i] < arr[j] && brr[i] > brr[j]) || (arr[i] > arr[j] && brr[i] < brr[j])) {
                        count++;
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}