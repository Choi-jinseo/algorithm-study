import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,N);
        System.out.println(white);
        System.out.println(blue);

        br.close();
    }
    static void dfs(int x, int y, int size) {
        int cnt = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                cnt += arr[i][j];
            }
        }
        if (cnt == 0) { // 0 으로 채워진 사각형
            white++;
        } else if (cnt == size * size) { // 1 로 채워진 사각형
            blue++;
        } else { // 네개로 나눠야함. (재귀 필요)
            int halfSize = size / 2;
            dfs (x, y, halfSize); // 좌상
            dfs (x+halfSize, y, halfSize); // 좌하
            dfs (x, y+halfSize, halfSize); // 우상
            dfs (x+halfSize, y+halfSize, halfSize); // 우하
        }
    }
}
