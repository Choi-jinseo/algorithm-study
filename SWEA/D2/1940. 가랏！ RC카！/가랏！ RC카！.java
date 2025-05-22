import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int speed = 0; // 속도
            int go = 0; // 거리
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()); // 가속, 감속
                if (c == 1) { // 가속
                    int g = Integer.parseInt(st.nextToken());
                    speed += g;
                    go += speed;
                }
                else if (c == 2) {
                    int g = Integer.parseInt(st.nextToken());
                    speed -= g;
                    if (speed < 0) speed = 0;
                    go += speed;
                }
                else {
                    go += speed;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(go).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}