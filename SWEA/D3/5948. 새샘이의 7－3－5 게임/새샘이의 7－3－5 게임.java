import java.util.*;
import java.io.*;

class Solution {
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            arr = new int[7];
            answer = new int[300];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[7];
            dfs(visited, 0, 0);
            int count = 0;

            sb.append("#").append(t+1).append(" ");
            for (int i = 299; i >= 0; i--) {
                if (answer[i] != 0) {
                    count++;
                    if (count == 5) {
                        sb.append(i);
                        break;
                    }
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    static void dfs(boolean[] visited, int cnt, int sum) {
        if (cnt == 3) {
            answer[sum]++;
            return;
        }
        for (int i = 0; i < 7; i++) {
            if (!visited[i]) {
                boolean[] vc = visited.clone();
                vc[i] = true;
                dfs(vc, cnt + 1, sum + arr[i]);
            }
        }
    }
}
