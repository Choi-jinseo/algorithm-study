import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 7; i++) { // 시작 요일
                int day = 0;
                int count = N;
                for (int j = i; count > 0;) {
                    if (arr[j] == 1) count--;
                    if (j == 6) j = 0;
                    else j++;
                    day++;
                }
                if (day < min) min = day;
            }

            sb.append("#").append(t + 1).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}