import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] rectangle = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                rectangle[i][j] = s.charAt(j);
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int leftTop = rectangle[i][j]; // 좌상
                for (int k = j; k < M; k++) {
                    int rightTop = rectangle[i][k]; // 우상
                    if (leftTop == rightTop) {
                        int dist = k - j;
                        if (i+dist >= N) break;
                        int leftBottom = rectangle[i+dist][j]; // 좌하
                        int rightBottom = rectangle[i+dist][k]; // 우하
                        if (leftTop == leftBottom && leftBottom == rightBottom) { // 정사각형
                            max = Math.max(max, (int)Math.pow(dist + 1, 2));
                        }
                    }
                }
            }
        }
        System.out.println(max);

        br.close();
    }
}