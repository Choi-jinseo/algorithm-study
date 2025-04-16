import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 15
        int S = Integer.parseInt(st.nextToken()); // 28
        int M = Integer.parseInt(st.nextToken()); // 19

        int year = 0;

        for (int i = 1; true; i++) {
            if ((i-1) % 15 + 1 == E && (i-1) % 28 + 1 == S && (i-1) % 19 + 1 == M) {
                System.out.println(i);
                break;
            }
        }

        br.close();
    }
}
