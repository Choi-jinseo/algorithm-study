import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 0; t < T; t++) {
            br.readLine();
            int N = 100;
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < N; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                if (max < rowSum) max = rowSum;
                if (max < colSum) max = colSum;
            }
            int dgs1Sum = 0;
            int dgs2Sum = 0;
            for (int i = 0; i < N; i++) {
                dgs1Sum += arr[i][i];
                dgs2Sum += arr[i][N - 1 - i];
            }
            if (max < dgs1Sum) max = dgs1Sum;
            if (max < dgs2Sum) max = dgs2Sum;
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}