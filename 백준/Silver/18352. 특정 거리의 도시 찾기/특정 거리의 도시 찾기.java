import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] node = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) node[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a].add(b);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int[] depth = new int[N+1]; // i번 노드의 깊이
        queue.add(X);
        depth[X] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (depth[cur] == K+2) break;
            for (int next : node[cur]) {
                if (depth[next] > 0) continue; // 방문한 녀석은 패스
                depth[next] = depth[cur] + 1;
                queue.add(next);
            }
        }
        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (depth[i] == K+1) {
                sb.append(i).append('\n');
                flag = true;
            }
        }
        if (flag) System.out.print(sb);
        else System.out.println(-1);

        br.close();
    }
}