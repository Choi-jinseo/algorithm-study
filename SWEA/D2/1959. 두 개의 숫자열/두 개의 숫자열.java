import java.util.*;
import java.io.*;
import java.util.*;
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] brr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;
            if (N == M) {
                for (int i = 0; i < N; i++) {
                    answer += arr[i] * brr[i];
                }
            }
            else if (N < M) {
                for (int i = 0; i <= M-N; i++) {
                    int cnt = 0;
                    for (int j = 0; j < N; j++) {
                        cnt += arr[j] * brr[j+i];
                    }
                    if (cnt > answer) answer = cnt;
                }
            }
            else { // N > M
                for (int i = 0; i <= N-M; i++) {
                    int cnt = 0;
                    for (int j = 0; j < M; j++) {
                        cnt += arr[j+i] * brr[j];
                    }
                    if (cnt > answer) answer = cnt;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}