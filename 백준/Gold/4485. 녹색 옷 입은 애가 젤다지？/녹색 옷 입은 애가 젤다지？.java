import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int T = 0;
        while (true) {
            T++;
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int[][] arr = new int[N][N];
            int[][] cost = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = -1;
                }
            }
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0,0});
            cost[0][0] = arr[0][0];
            while(!queue.isEmpty()) {
                int[] n = queue.poll();
                int x = n[0];
                int y = n[1];
                for (int i = 0; i < 4; i++) {
                    int dx = x + d[i][0];
                    int dy = y + d[i][1];
                    if (0<=dx && dx<N && 0<=dy && dy<N) {
                        if (cost[dx][dy] == -1 || cost[x][y] + arr[dx][dy] < cost[dx][dy]) {
                            queue.add(new int[]{dx,dy});
                            cost[dx][dy] = cost[x][y] + arr[dx][dy];
                        }
                    }
                }
            }
            sb.append("Problem ").append(T).append(": ").append(cost[N - 1][N - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
