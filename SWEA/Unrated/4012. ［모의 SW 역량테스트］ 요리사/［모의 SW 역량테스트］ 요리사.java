import java.util.*;
import java.io.*;

class Solution {
    static int[][] srr;
    static int N;
    static int min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            srr = new int[N][N];
            min = Integer.MAX_VALUE;
            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    srr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(visited, 0, 0);
            sb.append("#").append(t + 1).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(boolean[] visited, int idx, int count) {
        if (count == N / 2) {
            // 최소값 계산
            int s1 = 0;
            int s2 = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) { // 1-1
                    for (int j = i+1; j < N; j++) {
                        if (visited[j]) { // 1-2
                            s1 += (srr[i][j] + srr[j][i]);
                        }
                    }
                }
                else { // 2-1
                    for (int j = i+1; j < N; j++) {
                        if (!visited[j]) { // 2-2
                            s2 += (srr[i][j] + srr[j][i]);
                        }
                    }
                }
            }
            min = Math.min(Math.abs(s1 - s2), min);
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                boolean[] vc = visited.clone();
                vc[i] = true;
                dfs(vc, i + 1, count + 1);
            }
        }
    }
}