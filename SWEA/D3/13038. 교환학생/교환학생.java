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
            int count = 0; // 일주일 동안 수업 수
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 1) count++;
            }
            int[] min = new int[count + 1];
            min[1] = 1;
            for (int i = 2; i < count + 1; i++) {
                min[i] = 8;
                for (int j = 0; j < 7; j++) { // 시작
                    int num = i;
                    int day = 0;
                    for (int k = j; k < 14 && num > 0; k++, day++) { // 끝
                        if (arr[k % 7] == 1) num--;
                    }
                    min[i] = Math.min(min[i], day);
                }
            }
            int answer = ((N-1) / count) * 7 + min[(N-1) % count + 1];

            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}