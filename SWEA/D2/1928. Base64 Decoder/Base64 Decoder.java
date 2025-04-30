import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int[] buffer = new int[str.length() * 6];
            int cursor = 0;
            // buffer 을 8로 끊으면서 int 로 변환하고 (char)65 <-- 이렇게 된놈을 sb.append()하기
            for (int i = 0; i < str.length(); i++) {
                int value = 0;
                if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') value = str.charAt(i) - 'A';
                else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') value = str.charAt(i) - 'a' + 26;
                else if ('0' <= str.charAt(i) && str.charAt(i) <= '9') value = str.charAt(i) - '0' + 52;
                else if (str.charAt(i) == '+') value = 62;
                else if (str.charAt(i) == '/') value = 63;
                for (int j = 0; j < 6; j++) {
                    if (value >= Math.pow(2, 5-j)) {
                        buffer[cursor + j] = 1;
                        value -= Math.pow(2, 5-j);
                    }
                    else buffer[cursor + j] = 0;
                }
                cursor += 6;
            }
            sb.append("#").append(t+1).append(" ");
            for (int i = 0; i < buffer.length; i+=8) {
                int value = 0;
                for (int j = 0; j < 8; j++) {
                    if (buffer[i+j] == 1) value += Math.pow(2, 7-j);
                }
                sb.append((char)value);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}