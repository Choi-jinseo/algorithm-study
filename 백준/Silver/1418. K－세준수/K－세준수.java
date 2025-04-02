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
            int sis = i; // 소인수
            for (int j = 2; j <= num; j++) {
                while (num % j == 0) {
                    sis = num;
                    num /= j;
                }
            }
            if (sis <= K) answer++;
        }
        System.out.println(answer);
        br.close();
    }
}