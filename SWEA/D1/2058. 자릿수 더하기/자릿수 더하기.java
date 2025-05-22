import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += (str.charAt(i) - '0');
            }
            sb.append(sum);
        }
        System.out.print(sb);
        br.close();
    }
}