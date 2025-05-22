import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 1; i <= N; i+=2) {
                sum += i;
            }
            for (int i = 2; i <= N; i+=2) {
                sum -= i;
            }
            sb.append("#").append(t+1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}