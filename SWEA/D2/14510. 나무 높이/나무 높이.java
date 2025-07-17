import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int king = 0; // 제일 큰 나무
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (king < arr[i]) king = arr[i];
            }
            int sum = 0; // 총 필요한 키
            for (int i = 0; i < N; i++) {
                sum += king - arr[i];
            }
            int max2 = 0; // 가능한 최대 +2 횟수
            for (int i = 0; i < N; i++) {
                max2 += (king - arr[i]) / 2;
            }
            int min = Integer.MAX_VALUE;
            // +2 횟수 : 0 ~ max2 인 경우
            for (int i = 0; i <= max2; i++) {
                int cnt1 = sum - i * 2;
                int cnt2 = i;
                min = Math.min(min, Math.max(cnt1*2-1, cnt2*2)); // 종료 날짜
            }
            sb.append("#").append(t + 1).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}