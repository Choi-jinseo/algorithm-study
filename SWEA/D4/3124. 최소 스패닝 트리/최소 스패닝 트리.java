import java.io.*;
import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
//            return this.weight - o.weight;
            return Integer.compare(this.weight, o.weight); // 위에꺼는 오버플로우 문제가 있을 수 있음
        }
    }
    static Edge[] edgeList;
    static int V, E;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken())-1;
                int to = Integer.parseInt(st.nextToken())-1;
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edgeList); // 가중치를 기준으로 오름차순 정렬
            parents = new int[V];
            make();

            long sum = 0;
            int cnt = V; // 집합 개수
            for (Edge e : edgeList) {
                // 사이클 여부는 union-find 로 해결한다.
                if (union(e.from, e.to)) {
                    sum += e.weight;
                    cnt--;
                }
                if (cnt == 1) break;
            }
            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static void make() { // 집합 V개 생성 메서드
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        if (rootA > rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return true;
    }
    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
}
