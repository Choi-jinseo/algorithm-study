import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            while(n > 0) {
                sum += n % 10;
                n /= 10;
            }
            sb.append(sum);
        }
        System.out.print(sb);
        br.close();
    }
}