import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine());
            int[] scores = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                scores[Integer.parseInt(st.nextToken())]++;
            }
            int max = 0;
            int answer = 0;
            for (int i = 0; i < 101; i++) {
                if (scores[i] >= max) {
                    max = scores[i]; // 최빈 점수
                    answer = i;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
