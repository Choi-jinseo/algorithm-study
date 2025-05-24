import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static int max;
    static int sum;
    static int min = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if ((arr[i][0] < arr[j][0] && arr[i][1] > arr[j][1]) || (arr[i][0] > arr[j][0] && arr[i][1] < arr[j][1])) {
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