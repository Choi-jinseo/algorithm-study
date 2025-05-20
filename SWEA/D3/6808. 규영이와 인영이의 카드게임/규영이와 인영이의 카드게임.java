import java.util.*;
import java.io.*;
public class Solution {
    static int[] arr;
    static int[] brr;
    static int win;
    static int lose;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] num = new int[19];
            arr = new int[9];
            brr = new int[9];
            win = 0;
            lose = 0;
            for (int i = 0; i < 9; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                num[arr[i]] = 1;
            }
            for (int i = 1, j = 0; i < 19; i++) {
                if (num[i] == 0) {
                    brr[j] = i;
                    j++;
                }
            }
            boolean[] visited = new boolean[9];
            dfs(visited, 0, 0, 0); // idx : 게임 번호 (0~8)
            sb.append("#").append(t+1).append(" ").append(win).append(" ").append(lose).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(boolean[] visited, int idx, int aPoint, int bPoint) {
        if (idx == 9) {
            if (aPoint > bPoint) win++;
            else if (aPoint < bPoint) lose++;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                boolean[] vc = visited.clone();
                vc[i] = true;
                if (arr[idx] > brr[i]) dfs(vc, idx + 1, aPoint + arr[idx] + brr[i], bPoint);
                else dfs(vc, idx + 1, aPoint, bPoint + arr[idx] + brr[i]);
            }
        }
    }
}
