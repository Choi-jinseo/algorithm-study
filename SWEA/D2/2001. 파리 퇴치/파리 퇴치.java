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
            int M = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    // 여기서 시작
                    int fly = 0; // 파리채의 파리 수
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            fly += arr[k][l];
                        }
                    }
                    if (max < fly) max = fly;
                }
            }
            sb.append("#").append(t+1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
