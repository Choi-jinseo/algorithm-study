import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int answer = 0;
//        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15;  3;
//        1 2 3 2 5 3 7 2 3 5  11 3  13 7  5;

        for (int i = 1; i <= N; i++) {
            int num = i; // 분해된 수
            int max = i; // 최대 소인수
            for (int j = 2; j <= Math.sqrt(i); j++) {
                while (num % j == 0) {
                    num /= j;
                    if (num > 1) max = num;
                    else max = j;
                }
            }
            if (max <= K) answer++;
        }
        System.out.println(answer);
        br.close();
    }
}