import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static String[] map;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }
        ArrayList<Integer> counts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i].charAt(j) == '1' && !visited[i][j]) {
                    count = 0;
                    dfs(i, j, N);
                    counts.add(count);
                }
            }
        }
        Collections.sort(counts);
        sb.append(counts.size()).append('\n');
        for (Integer count : counts) {
            sb.append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(int i, int j, int N){
        visited[i][j] = true;
        count++;
        if (i-1 >= 0 && !visited[i-1][j] && map[i-1].charAt(j) == '1') dfs(i-1, j, N);
        if (i+1 < N && !visited[i+1][j] && map[i+1].charAt(j) == '1') dfs(i+1, j, N);
        if (j-1 >= 0 && !visited[i][j-1] && map[i].charAt(j-1) == '1') dfs(i, j-1, N);
        if (j+1 < N && !visited[i][j+1] && map[i].charAt(j+1) == '1') dfs(i, j+1, N);
    }
}