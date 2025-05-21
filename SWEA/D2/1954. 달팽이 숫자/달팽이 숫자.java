import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int G = N / 2; // 껍질 수
            int num = 1; // 1 ~ N
            int[][] arr = new int[N][N];
            if (N % 2 == 1) arr[N/2][N/2] = N * N;
            for (int i = 0; i < G; i++) {
                for (int j = i; j < N - 1 - i; j++) { // 껍질 위쪽
                    arr[i][j] = num;
                    num++;
                }
                for (int j = i; j < N - 1 - i; j++) { // 껍질 오른쪽
                    arr[j][N-1-i] = num;
                    num++;
                }
                for (int j = i; j < N - 1 - i; j++) { // 껍질 아래쪽
                    arr[N-1-i][N-1-j] = num;
                    num++;
                }
                for (int j = i; j < N - 1 - i; j++) { // 껍질 왼쪽
                    arr[N-1-j][i] = num;
                    num++;
                }
            }
            sb.append("#").append(t + 1).append('\n');
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}
