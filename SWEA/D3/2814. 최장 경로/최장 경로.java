import java.io.*;
import java.util.*;

class Solution {
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] arr = new boolean[N][N];
            boolean[] visited = new boolean[N];
            max = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                arr[x][y] = true;
                arr[y][x] = true;
            }
            for (int i = 0; i < N; i++) {
                boolean[] vc = visited.clone();
                vc[i] = true;
                dfs(arr, vc, i, 1);
            }
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(boolean[][] arr, boolean[] visited, int i, int count) {
        boolean flag = false;
        for (int k = 0; k < arr[0].length; k++) {
            if (arr[i][k] && !visited[k]) {
                flag = true;
                boolean[][] brr = new boolean[arr[0].length][arr[0].length];
                for (int j = 0; j < arr.length; j++) {
                    brr[j] = arr[j].clone();
                }
                brr[k][i] = false;
                brr[k][i] = false;
                boolean[] vc = visited.clone();
                vc[k] = true;
                dfs(brr, vc, k, count + 1);
            }
        }
        if (!flag && count > max) max = count;
    }
}