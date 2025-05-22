import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M1 = Integer.parseInt(st.nextToken());
            int D1 = Integer.parseInt(st.nextToken());
            int M2 = Integer.parseInt(st.nextToken());
            int D2 = Integer.parseInt(st.nextToken());
            int answer = 0;
            if (M1 == M2) {
                answer = D2 - D1;
            }
            else {
                if (M1 == 2) answer += (28 - D1);
                else if (M1 == 4 || M1 == 6 || M1 == 9 || M1 == 11) answer += (30 - D1);
                else answer += (31 - D1);
                for (int i = M1 + 1; i < M2; i++) {
                    if (i == 2) answer += 28;
                    else if (i == 4 || i == 6 || i == 9 || i == 11) answer += 30;
                    else answer += 31;
                }
                answer += D2;
            }
            answer += 1;
            sb.append("#").append(t+1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}