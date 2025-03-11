import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char[][] friends = new char[N][N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                friends[i][j] = str.charAt(j);
                dist[i][j] = friends[i][j] == 'Y' ? 0 : 2;
            }
        }

        for (int k = 0; k < N; k++) { // 중간다리 친구
            for (int i = 0; i < N; i++) { // 현재 사람
                for (int j = 0; j < N; j++) { // 2-친구 사람
                    if (j == i || k == i || k == j) continue;
                    if (friends[i][k] == 'Y' && friends[k][j] == 'Y') {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (dist[i][j] < 2) count++;
            }
            if (max < count) {
                max = count;
            }
        }
        System.out.println(max);
        br.close();
    }
}