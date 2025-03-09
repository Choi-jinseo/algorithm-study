import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //      한수 : 146, 135, 543

        int N = Integer.parseInt(st.nextToken());
        int M = N; // 자릿수 구할때 사용할 일회용 변수
        int digit = 0; // N 의 자릿수

        // 자릿수 구하기
        while (M > 0) {
            M = M / 10;
            digit++;
        }

        // 한 자리수 일때
        if (digit == 1) {
            System.out.println(N);
        }
        // 두 자리수 일때
        else if (digit == 2) {
            System.out.println(N);
        }
        // 세 자릿수 일때
        else if (digit == 3 || digit == 4) {
            if (digit == 4) N = 999; // N 이 1000 이면 999 까지만 구하면 된다. 1000은 한수가 아님
            int count = 99; // 1~99 까지는 모두 한 수 이므로
            for (int i = 100; i <= N; i++) {
                int hun = i / 100;
                int ten = (i % 100) / 10;
                int one = i % 10;

                int distHunToTen = hun - ten; // 백의 자리 - 십의 자리
                int distTenToOne = ten - one; // 십의 자리 - 일의 자리

                if (distHunToTen == distTenToOne) {
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}