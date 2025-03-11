import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 도시
        int m = Integer.parseInt(br.readLine()); // 버스

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = 10000001;
            }
        }

        for (int i = 0; i < m; i++) { // 버스 정보 (시작 도시, 도착 도시, 1회 비용)
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            if (a == b) continue;
            cost[a][b] = Math.min(cost[a][b], c);
        }

        for (int k = 0; k < n; k++) { // 경유 도시
            for (int i = 0; i < n; i++) { // 시작 도시
                for (int j = 0; j < n; j++) { // 도착 도시
                    if (i == j) continue;
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] == 10000001) System.out.print(0 + " ");
                else System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}