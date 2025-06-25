import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] arr = new String[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = st.nextToken();
            }
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < 10; i++) {
                int sum = 0;
                for (int j = 0; j < arr[i].length(); j++) {
                    sum += arr[i].charAt(j) - '0';
                }
                if (sum < min) min = sum;
                if (sum > max) max = sum;
            }
            sb.append("#").append(t + 1).append(" ").append(max).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}