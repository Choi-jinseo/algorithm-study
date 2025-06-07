import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int N = (int)Math.pow(2, K);
            ArrayList<Integer> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int answer = 0;
            for (int i = 0; i < Math.pow(2, K - 1); i++) {
                for (int j = N-1; j > 0; j-=2) {
                    if (arr.get(j) <= arr.get(j-1)) {
                        answer += arr.get(j-1) - arr.get(j);
                        arr.remove(j);
                    }
                    else {
                        answer += arr.get(j) - arr.get(j-1);
                        arr.remove(j-1);
                    }
                }
                N /= 2;
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}