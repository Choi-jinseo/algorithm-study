import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[][] ans = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    ans[i][j] = i * N + j + 1;
                }
            }
            int count = 0;
            for (int i = N-1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[i][j] != ans[i][j]) {
                        swap(arr, i);
                        count++;
                        break;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void swap(int[][] arr, int tSize) {
        for (int i = 1; i <= tSize; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}