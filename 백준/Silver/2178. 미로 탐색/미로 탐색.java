import java.io.*;
import java.util.*;

public class Main {
    static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N, M;
    static int[][] arr;
    static int[][] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        cost = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        cost[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int i = 0; i < 4; i++) {
                int dx = x + d[i][0];
                int dy = y + d[i][1];
                if (0<=dx && dx<N && 0<=dy && dy<M && arr[dx][dy] == 1) {
                    if (cost[dx][dy] == 0 || cost[x][y] + arr[dx][dy] < cost[dx][dy]) {
                        cost[dx][dy] = cost[x][y] + arr[dx][dy];
                        queue.add(new int[]{dx,dy});
                    }
                }
            }
        }
        System.out.println(cost[N-1][M-1]);
    }
}
