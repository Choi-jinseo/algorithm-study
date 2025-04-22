import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] child;
    static int[] parent;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        child = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }
        parent = new int[N];
        int root = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            parent[i] = p;
            if (p == -1) root = i;
            else child[p].add(i);
        }

        st = new StringTokenizer(br.readLine());
        Integer M = Integer.parseInt(st.nextToken());
        if (parent[M] == -1) System.out.println(0);
        else {
            child[parent[M]].remove(M); // 서브트리 끊기
            dfs(child, root);
            System.out.println(count);
        }

        br.close();
    }
    static void dfs(ArrayList<Integer>[] child, int n) {
        if (child[n].isEmpty()) count++;
        for (Integer c : child[n]) {
            dfs(child, c);
        }
    }
}
