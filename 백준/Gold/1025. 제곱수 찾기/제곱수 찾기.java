import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] s = new String[N];
        int max = -1;

        for (int i = 0; i < N; i++) {
            s[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) { // 기준 x
            for (int j = 0; j < M; j++) { // 기준 y
                for (int dx = -i; dx < N-i; dx++) { // x 공차
                    for (int dy = -j; dy < M-j; dy++) { // y 공차
                        String num = "";
                        int x = i; // 순회 x
                        int y = j; // 순회 y
                        while (0 <= x && x < N && 0 <= y && y < M) { // 벗어나지 않는 인덱스
                            num += s[x].charAt(y);
                            double sqrt = Math.sqrt(Integer.parseInt(num));
                            if ((int)sqrt == sqrt) max = Math.max(Integer.parseInt(num), max);
                            x += dx;
                            y += dy;
                            if (dx == 0 && dy == 0) break;
                        }
                    }
                }
            }
        }
        System.out.println(max);
        br.close();
    }
}
