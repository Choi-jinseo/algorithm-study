import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 4; i <= 1000000000 - N; i++) { // 왼쪽 합성수
                int j = i + N; // 오른쪽 합성수
                boolean flag1 = false;
                boolean flag2 = false;
                // 1 과 자신 사이의 수로 나누어 지는지 확인
                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        flag1 = true;
                        break;
                    }
                }
                for (int k = 2; k < i + N; k++) {
                    if (j % k == 0) {
                        flag2 = true;
                        break;
                    }
                }
                if (flag1 && flag2) {
                    sb.append("#").append(t + 1).append(" ").append(j).append(" ").append(i).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}