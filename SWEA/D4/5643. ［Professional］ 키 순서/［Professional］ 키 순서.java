import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] under;
    static ArrayList<Integer>[] upper;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 학생 수
            int M = Integer.parseInt(br.readLine()); // 비교 수
            under = new ArrayList[N];
            upper = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                under[i] = new ArrayList<>();
                upper[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                under[a].add(b);
                upper[b].add(a);
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                Queue<Integer> queue = new ArrayDeque<>();
                boolean[] visited = new boolean[N];
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int child : upper[node]) {
                        if (!visited[child]) {
                            queue.add(child);
                            visited[child] = true;
                        }
                    }
                }
                queue.add(i);
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int child : under[node]) {
                        if (!visited[child]) {
                            queue.add(child);
                            visited[child] = true;
                        }
                    }
                }
                boolean known = true;
                for (int j = 0; j < N; j++) {
                    if (!visited[j]) {
                        known = false;
                        break;
                    }
                }
                if (known) cnt++;
            }
            sb.append("#").append(t + 1).append(" ").append(cnt).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}