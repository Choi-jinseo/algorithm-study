import java.io.*;
import java.util.*;

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
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            if (arr.length <= brr.length) {
                for (int i = 0; i <= brr.length - arr.length; i++) {
                    // 시작 위치
                    int sum = 0;
                    for (int j = 0; j < arr.length; j++) {
                        sum += (arr[j] * brr[i+j]);
                    }
                    if (sum > max) max = sum;
                }
            }
            else {
                for (int i = 0; i <= arr.length - brr.length; i++) {
                    // 시작 위치
                    int sum = 0;
                    for (int j = 0; j < brr.length; j++) {
                        sum += (brr[j] * arr[i+j]);
                    }
                    if (sum > max) max = sum;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}