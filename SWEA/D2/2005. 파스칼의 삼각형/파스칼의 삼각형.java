import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                arr[i][0] = 1;
                arr[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
            sb.append("#").append(t+1).append('\n');
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}