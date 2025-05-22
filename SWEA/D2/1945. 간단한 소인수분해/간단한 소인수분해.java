import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(t+1).append(" ");
            int x = 0;
            while (N % 2 == 0) {
                x++;
                N /= 2;
            }
            sb.append(x).append(" ");
            x = 0;
            while (N % 3 == 0) {
                x++;
                N /= 3;
            }
            sb.append(x).append(" ");
            x = 0;
            while (N % 5 == 0) {
                x++;
                N /= 5;
            }
            sb.append(x).append(" ");
            x = 0;
            while (N % 7 == 0) {
                x++;
                N /= 7;
            }
            sb.append(x).append(" ");
            x = 0;
            while (N % 11 == 0) {
                x++;
                N /= 11;
            }
            sb.append(x).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}