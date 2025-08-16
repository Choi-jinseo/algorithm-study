import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N]; // 나무정보
            int king = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (king < arr[i]) king = arr[i];
            }
            int one = 0;
            int two = 0;
            for (int i = 0; i < N; i++) {
                int dist = king - arr[i];
                one += dist % 2;
                two += dist / 2;
            }
            // +2 : 0 ~ two
            int min = Integer.MAX_VALUE;
            while(two >= 0) {
                int end = Math.max(one * 2 - 1, two * 2); // 끝나는 점
                if (end < min) min = end;
                two -= 1;
                one += 2;
            }
            sb.append("#").append(t + 1).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}