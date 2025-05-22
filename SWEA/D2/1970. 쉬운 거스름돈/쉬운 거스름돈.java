import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[8]; // 동전 단위
            if (N >= 50000) {
                arr[0] = N / 50000;
                N = N % 50000;
            }
            if (N >= 10000) {
                arr[1] = N / 10000;
                N = N % 10000;
            }
            if (N >= 5000) {
                arr[2] = N / 5000;
                N = N % 5000;
            }
            if (N >= 1000) {
                arr[3] = N / 1000;
                N = N % 1000;
            }
            if (N >= 500) {
                arr[4] = N / 500;
                N = N % 500;
            }
            if (N >= 100) {
                arr[5] = N / 100;
                N = N % 100;
            }
            if (N >= 50) {
                arr[6] = N / 50;
                N = N % 50;
            }
            if (N >= 10) {
                arr[7] = N / 10;
            }
            sb.append("#").append(t + 1).append('\n');
            for (int i = 0; i < 8; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}