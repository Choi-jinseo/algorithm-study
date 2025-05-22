import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashSet<Integer> hs = new HashSet<>();
            int i = N;
            int k = 0;
            while (hs.size() < 10) {
                String str = Integer.toString(i);
                for (int j = 0; j < str.length(); j++) {
                    hs.add(str.charAt(j) - '0');
                }
                k++;
                i += N;
            }
            sb.append("#").append(t+1).append(" ").append(k*N).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}