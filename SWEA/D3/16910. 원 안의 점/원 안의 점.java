import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            // 1사분면
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    if (i * i + j * j <= N * N) {
                        count++;
                    }
                }
            }
            count = count * 4 + 1; // 1,2,3,4 분면 + 원점
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}