import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] table = new int[N]; // N-1, N의 캔디 합
        int[] candy = new int[N]; // 각 사람의 캔디 수

        for (int i = 0; i < N; i++) {
            table[i] = Integer.parseInt(br.readLine());
        }
        for (int one = 0; one <= 100000; one++) { // 1번 학생의 사탕
            candy[0] = one;
            for (int i = 1; i < N; i++) {
                candy[i] = table[i-1] - candy[i-1];
            }
            if (candy[N-1] + candy[0] == table[N-1]) {
                for (int i = 0; i < N; i++) {
                    sb.append(candy[i]).append('\n');
                }
                System.out.print(sb);
                break;
            }
        }

        br.close();
    }
}