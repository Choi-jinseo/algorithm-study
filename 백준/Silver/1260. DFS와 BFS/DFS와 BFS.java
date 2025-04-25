import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] nodes;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        nodes = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodes[u].add(v);
            nodes[v].add(u);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(nodes[i]);
        }
        dfs(V);
        System.out.println(sb);
        sb.setLength(0);
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
        br.close();
    }
    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (Integer next : nodes[node]) {
            if (!visited[next]) dfs(next);
        }
    }
    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            for (Integer next : nodes[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}