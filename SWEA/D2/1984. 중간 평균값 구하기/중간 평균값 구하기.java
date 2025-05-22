import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10001];
            for (int i = 0; i < 10; i++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
            int max = 10000;
            int min = 0;
            int count = 0;
            for (int i = 10000; i >= 0; i--) {
                if (arr[i] != 0) {
                    max = i;
                    count += arr[i];
                    break;
                }
            }
            for (int i = 0; i <= 10000; i++) {
                if (arr[i] != 0) {
                    min = i;
                    count += arr[i];
                    break;
                }
            }
            int answer = 0;
            if (min == max || count == 10) answer = 0;
            else {
                int sum = 0;
                int num = 0;
                for (int i = min+1; i < max; i++) {
                    sum += (i * arr[i]); // 그 수, 그 수의 개수
                    num += arr[i];
                }
                if ((double)sum / num - sum / num >= 0.5) answer = sum / num + 1;
                else answer = sum / num;
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}