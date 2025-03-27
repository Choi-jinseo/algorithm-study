import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int underPrime = 0; // 언더프라임 개수

        for (int num = A; num <= B; num++) {
            int val = num;
            int count = 0;
            for (int i = 2; i <= val; i++) {
                while(val % i == 0) {
                    val = val / i;
                    count++;
                }
            }
            // 소수인지 체크
            boolean isPrime = true;
            if (count <= 1) isPrime = false;
            for (int i = 2; i <= Math.sqrt(count); i++) {
                if (count % i == 0) {
                    isPrime = false; // 소수 아님
                    break;
                }
            }
            if (isPrime) underPrime++;
        }
        System.out.println(underPrime);
    }
}