import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        arr = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[p].add(c);
            arr[c].add(p);
        }
        dfs(u, v, 0);
        if (!flag) System.out.println(-1);

        br.close();
    }
    static void dfs(int u, int v, int count) {
        visited[u] = true;
        if (u == v) {
            System.out.println(count);
            flag = true;
        }
        count++;
        for (Integer c : arr[u]) {
            if (!visited[c]) dfs(c, v, count);
        }
    }
}