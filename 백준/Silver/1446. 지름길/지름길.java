import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static J[] shortcut;
    static ArrayList<Integer>[] next;
    static int D;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        min = D;
        shortcut = new J[N];
        next = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            next[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (v <= D && d < v-u) shortcut[i] = new J(u,v,d);
        }
        for (int i = 0; i < N; i++) {
            if (shortcut[i] == null) continue;
            for (int j = 0; j < N; j++) {
                if (shortcut[j] == null) continue;
                if (i == j) continue;
                if (shortcut[i].v <= shortcut[j].u) { // 연결
                    next[i].add(j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (shortcut[i] != null) dfs(i, shortcut[i].u);
        }
        System.out.println(min);

        br.close();
    }
    static void dfs(int i, int dist) {
        dist += shortcut[i].d;
        if (next[i].isEmpty()) min = Math.min(min, dist + (D-shortcut[i].v));
        for (Integer j : next[i]) {
            dfs(j, dist + (shortcut[j].u - shortcut[i].v));
        }
    }
    static class J {
        int u;
        int v;
        int d;
        J(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }
    }
}