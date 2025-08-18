import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
        int T = 10;
        for (int t = 0; t < T; t++) {
            // 입력 및 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] node = new ArrayList[V+1];
            for (int i = 0; i < V + 1; i++) node[i] = new ArrayList<>();

            int[] parents = new int[V+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                node[a].add(b);
                parents[b]++;
            }
            // 위상 정렬 (bfs)
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i < V; i++) {
                if (parents[i] == 0) {
                    queue.add(i); // 부모 없는 노드 모두 집어넣기
                }
            }
            sb.append("#").append(t + 1);
            while(!queue.isEmpty()) {
                int p = queue.poll();
                sb.append(" ").append(p);
                for (int c : node[p]) {
                    parents[c]--;
                    if (parents[c] == 0) {
                        queue.add(c);
                    }
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}