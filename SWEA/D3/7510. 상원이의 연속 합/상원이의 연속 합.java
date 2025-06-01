import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 1; i <= N; i++) { // 시작 숫자
                int sum = 0;
                for (int j = i; j <= N; j++) {
                    sum += j;
                    if (sum == N) {
                        count++;
                        break;
                    }
                    else if (sum > N) break;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}