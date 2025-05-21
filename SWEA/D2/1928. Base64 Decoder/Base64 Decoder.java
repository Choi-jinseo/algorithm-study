import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int[] buffer = new int[str.length() * 6];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int value = 0;
                if ('A' <= c && c <= 'Z') value = c - 'A';
                else if ('a' <= c && c <= 'z') value = c - 'a' + 26;
                else if ('0' <= c && c <= '9') value = c - '0' + 52;
                else if (c == '+') value = 62;
                else if (c == '/') value = 63;
                for (int j = 0; j < 6; j++) {
                    if (value >= Math.pow(2, 5 - j)) {
                        buffer[i * 6 + j] = 1;
                        value -= Math.pow(2, 5 - j);
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ");
            for (int i = 0; i < buffer.length; i+=8) {
                char sum = 0;
                for (int j = 0; j < 8; j++) {
                    if (buffer[i+j] == 1) sum += Math.pow(2, 7-j);
                }
                sb.append(sum);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
