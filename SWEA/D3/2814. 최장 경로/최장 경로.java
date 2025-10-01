import java.io.*;
import java.nio.Buffer;
import java.util.*;
public class Solution {
    static int N;
    static boolean[][] arr;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점 개수
            int M = Integer.parseInt(st.nextToken()); // 간선 개수

            arr = new boolean[N][N];
            visited = new boolean[N];
            max = 0;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                arr[start][end] = true;
                arr[end][start] = true;
            }

            for (int i = 0; i < N; i++) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }

            sb.append("#").append(t).append(" ").append(max).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static void dfs(int cur, int sum) {
        max = Math.max(sum, max);
        for (int i = 0; i < N; i++) {
            if (arr[cur][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, sum + 1);
                visited[i] = false;
            }
        }
    }
}
