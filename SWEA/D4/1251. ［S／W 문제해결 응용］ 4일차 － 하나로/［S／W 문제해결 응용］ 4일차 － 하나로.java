import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static class Edge implements Comparable<Edge> {
        int from, to;
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Point[] pointList;
    static Edge[] edgeList;
    static int[] parents;
    static int V, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            V = Integer.parseInt(br.readLine()); // 섬의 개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] xrr = new int[V];
            int[] yrr = new int[V];
            for (int i = 0; i < V; i++) {
                xrr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < V; i++) {
                yrr[i] = Integer.parseInt(st.nextToken());
            }
            double rate = Double.parseDouble(br.readLine());
            // 정점 리스트 만들기
            pointList = new Point[V];
            for (int i = 0; i < V; i++) {
                pointList[i] = new Point(xrr[i], yrr[i]);
            }

            // 간선 리스트 만들기
            E = V*(V-1)/2; // 간선 개수
            edgeList = new Edge[E];
            int idx = 0;
            for (int i = 0; i < V; i++) { // 출발 점
                for (int j = i+1; j < V; j++) { // 도착 점
                    int x1 = pointList[i].x;
                    int y1 = pointList[i].y;
                    int x2 = pointList[j].x;
                    int y2 = pointList[j].y;
                    long weight = (long) (x1 - x2) * (x1-x2) + (long) (y1 - y2) * (y1-y2);
                    edgeList[idx++] = new Edge(i, j, weight); // i정점, j정점, 가중치
                }
            }
            Arrays.sort(edgeList);
            make();

            int cnt = V; // 집합 개수
            long sum = 0; // 가중치 합
            for (int i = 0; i < E; i++) {
                if (union(edgeList[i].from, edgeList[i].to)) {
                    cnt--;
                    sum += edgeList[i].weight;
                }
                if (cnt == 1) break; // 정점들이 집합 1개로 연결되었다면 break
            }
            sb.append("#").append(t).append(" ").append(Math.round(sum * rate)).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static void make() {
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }
    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        if (rootA > rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
        return true;
    }
}