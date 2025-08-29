import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            String str = br.readLine();
            Set<Integer> ts = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                char[] hex = new char[N/4];
                for (int j = i; j < i+N/4; j++) {
                    hex[j-i] = str.charAt(j%N);
                }
                int num = hexToDec(hex);
                ts.add(num);
            }
            int answer = 0;
            int iter = 0;
            for (int num : ts) {
                if (iter == ts.size() - K) {
                    answer = num;
                    break;
                }
                iter++;
            }
            sb.append("#").append(t).append(" ").append(answer).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static int hexToDec(char[] hex) {
        int dec = 0;
        for (int i = 0; i < hex.length; i++) {
            char c = hex[i];
            int d;
            if (c >= 'A' && c <= 'F') d = c - 'A' + 10;
            else d = c - '0';
            dec += d * Math.pow(16, hex.length-1-i);
        }
        return dec;
    }
}