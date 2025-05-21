import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str = Integer.toString(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    count++;
                }
            }
            if (count == 0) sb.append(str);
            else {
                for (int j = 0; j < count; j++) {
                    sb.append('-');
                }
            }
            sb.append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
