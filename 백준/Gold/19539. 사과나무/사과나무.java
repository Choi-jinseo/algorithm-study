import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 나무 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = 0, two = 0;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            one += t % 2;
            two += t / 2;
        }
        if (two >= one && (two - one) % 3 == 0) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}