import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 입력 수
            int K = Integer.parseInt(st.nextToken()); // 당번 번호

            // 발신자 -> 수신자 정보 입력
            ArrayList<Integer>[] arr = new ArrayList[101];
            for (int i = 0; i < 101; i++) arr[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i+=2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b); // a 는 b 에게 연락가능
            }

            // K 를 루트로 탐색(bfs) 시작
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(K);
            boolean[] visited = new boolean[101];
            visited[K] = true;
            int[] level = new int[101]; // 노드의 레벨
            level[K] = 0;
            int lastLevel = 0; // 마지막에 연락받은 사람들의 레벨

            while(!queue.isEmpty()) {
                int p = queue.poll();
                for (int c : arr[p]) {
                    if (!visited[c]) {
                        queue.add(c);
                        visited[c] = true;
                        level[c] = level[p]+1;
                        lastLevel = level[c];
                    }
                }
            }
            int max = 0; // 마지막 수신자 중 번호가 가장 큰사람
            for (int i = 1; i < 101; i++) {
                if (level[i] == lastLevel) { // 마지막에 연락받은 사람이면
                    max = Math.max(max, i); // 가장 번호가 큰 사람으로 갱신
                }
            }

            sb.append("#").append(t+1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}