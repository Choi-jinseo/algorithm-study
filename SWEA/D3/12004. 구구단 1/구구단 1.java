import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(t + 1).append(" ");
            if (N < 10) sb.append("Yes");
            else {
                boolean flag = false;
                for (int i = 9; i > 1; i--) {
                    if (N % i == 0) {
                        if (N / i < 10) sb.append("Yes");
                        else sb.append("No");
                        flag = true;
                        break;
                    }
                }
                if (!flag) sb.append("No");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}