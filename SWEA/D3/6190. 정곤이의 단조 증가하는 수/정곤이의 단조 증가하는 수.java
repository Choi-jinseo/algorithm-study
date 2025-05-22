import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            for (int i = 0; i < N-1; i++) { // 첫번째 수
                if (arr[i] % 10 == 0) continue;
                for (int j = i+1; j < N; j++) { // 두번째 수
                    if (arr[j] % 10 == 0) continue;
                    if (max >= arr[i] * arr[j]) continue;
                    boolean flag = false;
                    int temp = arr[i] * arr[j];
                    while (temp > 0) {
                        int right = temp % 10;
                        int left = (temp / 10) % 10;
                        if (left > right) {
                            flag = true;
                            break;
                        }
                        temp /= 10;
                    }
                    if (!flag) { // 단조 증가 수
                        max = Math.max(max, arr[i] * arr[j]);
                    }
                }
            }
            sb.append("#").append(t+1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}