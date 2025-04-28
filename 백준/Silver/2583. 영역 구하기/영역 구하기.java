import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] arr;
    static int M;
    static int N;
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static ArrayList<Integer> areaSize = new ArrayList<>();
    static int pointCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        int areaCnt = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    areaCnt++;
                    pointCnt = 0;
                    dfs(i, j);
                    areaSize.add(pointCnt);
                }
            }
        }
        Collections.sort(areaSize);
        sb.append(areaCnt).append('\n');
        for (Integer i : areaSize) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
    static void dfs(int i, int j) {
        pointCnt++;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int di = i + d[k][0];
            int dj = j + d[k][1];
            if (di >= 0 && di < N && dj >= 0 && dj < M) {
                if (!visited[di][dj] && arr[di][dj] == 0) dfs(di, dj);
            }
        }
    }
}