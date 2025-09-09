import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] len = new int[N+1];
            int idx = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (len[idx] < num) {
                    len[++idx] = num;
                } else {
                    // 이분탐색
                    int start = 0;
                    int end = idx;
                    while (start < end) {
                        int mid = (start + end) / 2;
                        if (len[mid] < num) {
                            start = mid+1;
                        } else {
                            end = mid;
                        }
                    }
                    len[end] = num;
                }
            }
            sb.append("#").append(t).append(" ").append(idx).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}