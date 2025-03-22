import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int i = L; i <= 100; i++) { // i : 연속수의 개수
            int middle = N/i;
            int start = middle - (i-1)/2;
            if (start < 0) break;
            int sum = 0;
            for (int j = start; j < start + i; j++) {
                sum += j;
            }
            if (sum == N) {
                for (int j = start; j < start + i; j++) {
                    System.out.print(j + " ");
                }
                return;
            }
        }
        System.out.println(-1);

        br.close();
    }
}