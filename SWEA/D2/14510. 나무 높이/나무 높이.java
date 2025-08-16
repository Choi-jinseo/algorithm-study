import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
            }
            int one = 0, two = 0;
            for (int i = 0; i < N; i++) {
                int temp = max - arr[i];
                two += temp / 2;
                one += temp % 2;
            }
            // (2)1개 -> (1)2개 로 조정
            if (one < two) {
                int temp = (two - one + 1) / 3;
                one += temp * 2;
                two -= temp;
            }
            int answer = 0;
            if (one == two) answer = one * 2;
            else if (one > two) answer = two * 2 + (one - two) * 2 - 1;
            else answer = one * 2 + 2;

            sb.append("#").append(t).append(" ").append(answer).append('\n');
        }
        System.out.println(sb);
    }
}