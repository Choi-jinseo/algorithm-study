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
                if (value >= 32) {
                    buffer[i * 6] = 1;
                    value -= 32;
                }
                if (value >= 16) {
                    buffer[i * 6 + 1] = 1;
                    value -= 16;
                }
                if (value >= 8) {
                    buffer[i * 6 + 2] = 1;
                    value -= 8;
                }
                if (value >= 4) {
                    buffer[i * 6 + 3] = 1;
                    value -= 4;
                }
                if (value >= 2) {
                    buffer[i * 6 + 4] = 1;
                    value -= 2;
                }
                if (value >= 1) {
                    buffer[i * 6 + 5] = 1;
                }
            }
            sb.append("#").append(t + 1).append(" ");
            for (int i = 0; i < buffer.length; i+=8) {
                char sum = 0;
                if (buffer[i] == 1) sum += 128;
                if (buffer[i+1] == 1) sum += 64;
                if (buffer[i+2] == 1) sum += 32;
                if (buffer[i+3] == 1) sum += 16;
                if (buffer[i+4] == 1) sum += 8;
                if (buffer[i+5] == 1) sum += 4;
                if (buffer[i+6] == 1) sum += 2;
                if (buffer[i+7] == 1) sum += 1;
                sb.append(sum);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
