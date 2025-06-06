import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                int N = Integer.parseInt(br.readLine());
                if (N != 0) arr.add(N);
                else arr.remove(arr.size() - 1);
            }
            long answer = 0;
            for (int N : arr) {
                answer += N;
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}