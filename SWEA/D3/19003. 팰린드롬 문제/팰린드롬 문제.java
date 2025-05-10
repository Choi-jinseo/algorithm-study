import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] str = new String[N];
            boolean[] couple = new boolean[N];
            boolean pal = false;
            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();
                couple[i] = false;
            }
            // couple 확인
            for (int i = 0; i < N; i++) {
                if (couple[i]) continue;
                for (int j = i + 1; j < N; j++) {
                    if (couple[j]) continue;
                    boolean flag = false;
                    for (int k = 0; k < M; k++) {
                        if (str[i].charAt(k) != str[j].charAt(M-1-k)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) { // couple
                        couple[i] = true;
                        couple[j] = true;
                        break;
                    }
                }
            }
            // pal 확인
            for (int i = 0; i < N; i++) {
                if (couple[i]) continue;
                boolean flag = false;
                for (int j = 0; j < M / 2; j++) {
                    if (str[i].charAt(j) != str[i].charAt(M-1-j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    pal = true;
                    break;
                }
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (couple[i]) count++;
            }
            if (pal) count++;
            sb.append("#").append(t + 1).append(" ").append(count * M).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}