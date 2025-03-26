import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int len = (int)Math.pow(2, N);
        int size = len * len;

        int count = 0;

        // 4등분
        while (N > 0) {
            if (r < len / 2 && c < len / 2) { // 좌상
            }
            else if (r < len / 2 && c >= len / 2) { // 우상
                c = c - len / 2;
                count += size / 4;
            }
            else if (r >= len / 2 && c < len / 2) { // 좌하
                r = r - len / 2;
                count += size / 2;
            }
            else { // 우하
                r = r - len / 2;
                c = c - len / 2;
                count += (size / 4) * 3;
            }
            len = len / 2;
            size = size / 4;
            N--;
        }
        System.out.println(count);
        br.close();
    }
}