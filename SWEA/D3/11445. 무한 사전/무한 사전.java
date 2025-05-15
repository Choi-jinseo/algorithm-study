import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String P = br.readLine();
            String Q = br.readLine();
            if (Q.equals(P + 'a')) sb.append("#").append(t + 1).append(" ").append('N').append('\n');
            else sb.append("#").append(t + 1).append(" ").append('Y').append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}