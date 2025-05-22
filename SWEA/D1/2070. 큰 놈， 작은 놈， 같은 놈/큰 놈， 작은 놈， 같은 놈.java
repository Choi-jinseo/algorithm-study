import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char answer;
            if (N < M) answer = '<';
            else if (N > M) answer = '>';
            else answer = '=';
            sb.append("#").append(t+1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}