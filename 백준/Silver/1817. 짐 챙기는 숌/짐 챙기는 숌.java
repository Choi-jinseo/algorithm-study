import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] books = new int[N];

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            if (sum + books[i] > M) {
                count++;
                sum = books[i];
            }
            else sum += books[i];
        }
        System.out.println(count);

        br.close();
    }
}