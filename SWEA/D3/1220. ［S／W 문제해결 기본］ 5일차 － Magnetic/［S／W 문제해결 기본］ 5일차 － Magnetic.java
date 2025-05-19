import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i = 0; i < N; i++) { // 열
                boolean redFlag = false;
                for (int j = 0; j < N; j++) { // 행
                    if (arr[j][i] == 1) { // 붉은색
                        redFlag = true;
                    }
                    else if (arr[j][i] == 2) { // 파란색
                        if (redFlag) {
                            count++;
                            redFlag = false;
                        }
                    }
                }
            }

            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}