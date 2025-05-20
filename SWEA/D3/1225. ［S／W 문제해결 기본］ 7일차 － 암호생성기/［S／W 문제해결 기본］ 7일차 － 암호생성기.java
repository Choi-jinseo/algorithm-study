import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int idx = 0;
            int num = 1;
            boolean flag = false;
            while(!flag) {
                if (arr[idx] - num <= 0) {
                    flag = true;
                    arr[idx] = 0;
                }
                else arr[idx] -= num;

                if (num == 5) num = 1;
                else num++;
                if (idx == 7) idx = 0;
                else idx++;
            }
            sb.append("#").append(tc);
            // idx 는 0 다음 순서를 가리킴
            for (int i = 0; i < 8; i++) {
                sb.append(" ").append(arr[(idx + i) % 8]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}