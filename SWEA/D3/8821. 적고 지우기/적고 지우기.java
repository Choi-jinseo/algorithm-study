import java.util.*;
import java.io.*;
import java.util.*;
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int[] arr = new int[10]; // 0~9
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - '0']++;
            }
            int answer = 0;
            for (int i = 0; i < 10; i++) {
                if (arr[i] % 2 == 1) {
                    answer++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}