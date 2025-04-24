import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> visited = new HashSet<>();
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine()); // 컴퓨터
        int N = Integer.parseInt(br.readLine()); // 네트워크
        arr = new ArrayList[C];
        for (int i = 0; i < C; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            arr[start].add(end);
            arr[end].add(start);
        }
        dfs(0);
        System.out.println(visited.size() - 1); // 1번 제외

        br.close();
    }
    static void dfs(int n) {
        visited.add(n);
        for (Integer m : arr[n]) {
            if (!visited.contains(m)) dfs(m);
        }
    }
}