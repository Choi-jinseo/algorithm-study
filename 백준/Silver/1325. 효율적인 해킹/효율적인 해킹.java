import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }
        cnt = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
        }
        for (int i = 1; i < N+1; i++) {
            visited = new boolean[N+1];
            bfs(i);
        }
        int max = 0;
        for (int i = 1; i < N+1; i++) {
            if (max < cnt[i]) max = cnt[i];
        }
        for (int i = 1; i < N+1; i++) {
            if (max == cnt[i]) System.out.print(i+" ");
        }
    }
    static void bfs(int i) {
        visited[i]= true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int child : arr[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    cnt[child]++;
                    queue.add(child);
                }
            }
        }
    }
}
