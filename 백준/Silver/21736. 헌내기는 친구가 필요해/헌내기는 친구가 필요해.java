import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static String[] arr;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new String[N];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i].charAt(j) == 'I') dfs(i,j);
            }
        }
        if (count == 0) System.out.println("TT");
        else System.out.println(count);
        br.close();
    }
    static void dfs(int i, int j) {
        if (arr[i].charAt(j) == 'P') count++;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int di = i + d[k][0];
            int dj = j + d[k][1];
            if (di >= 0 && di < arr.length && dj >= 0 && dj < arr[0].length()) {
                if (!visited[di][dj] && arr[di].charAt(dj) != 'X') {
                    dfs(di, dj);
                }
            }
        }
    }
}