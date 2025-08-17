import java.util.*;
import java.io.*;

class Solution {
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 입력 및 초기화
            int N = Integer.parseInt(br.readLine()); // 학생 수
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j)-'0';
                }
            }
            boolean[][] visited = new boolean[N][N];
            int[][] cost = new int[N][N];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0,0});
            visited[0][0] = true;
            cost[0][0] = arr[0][0];
            while(!queue.isEmpty()) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int i = 0; i < 4; i++) {
                    int dx = x + d[i][0];
                    int dy = y + d[i][1];
                    if (0<=dx && dx<N && 0<=dy && dy<N) {
                        if (!visited[dx][dy] || cost[x][y]+arr[dx][dy] < cost[dx][dy]) {
                            queue.add(new int[]{dx,dy});
                            visited[dx][dy] = true;
                            cost[dx][dy] = cost[x][y]+arr[dx][dy];
                        }
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(cost[N-1][N-1]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}