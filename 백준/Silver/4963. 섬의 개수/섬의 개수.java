import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int w;
    static int h;
    static int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> tc = new ArrayList<>();
        // 섬은 대각선으로도 연결가능하다.
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            visited = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            tc.add(count);
        }
        for (Integer count : tc) {
            sb.append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int di = i + d[k][0];
            int dj = j + d[k][1];
            if (di >= 0 && di < h && dj >= 0 && dj < w) {
                if (arr[di][dj] == 1 && !visited[di][dj]) dfs(di, dj);
            }
        }
    }
}