import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int count2 = 0;
        int count5 = 0;
        for (int i = 2; i <= N; i++) {
            int temp = i;
//            while (temp % 2 == 0) {
//                temp /= 2;
//                count2++;
//            }
            while (temp % 5 == 0) {
                temp /= 5;
                count5++;
            }
        }
//        System.out.println(Math.min(count2, count5));
        System.out.println(count5);
        br.close();
    }
}