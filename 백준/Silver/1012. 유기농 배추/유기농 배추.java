import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] farm = new int[M][N];
            int count = 0;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (farm[i][j] == 1) {
                        dfs(i, j, farm, M, N);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        br.close();
    }
    static void dfs(int x, int y, int[][] farm, int M, int N) {
        farm[x][y] = 0;
        if (x - 1 >= 0 && farm[x-1][y] == 1) dfs(x - 1, y, farm, M, N);
        if (x + 1 < M && farm[x+1][y] == 1) dfs(x + 1, y, farm, M, N);
        if (y - 1 >= 0 && farm[x][y-1] == 1) dfs(x, y - 1, farm, M, N);
        if (y + 1 < N && farm[x][y+1] == 1) dfs(x, y + 1, farm, M, N);
    }
}