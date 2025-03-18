import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int count = 0;
            int n = Integer.parseInt(br.readLine());
            for (int three = 0; three <= n; three=three+3) {
                for (int two = 0; two <= n - three; two=two+2) {
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}