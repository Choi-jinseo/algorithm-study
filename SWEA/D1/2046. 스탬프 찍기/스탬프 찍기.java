import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                sb.append('#');
            }
        }
        System.out.print(sb);
        br.close();
    }
}