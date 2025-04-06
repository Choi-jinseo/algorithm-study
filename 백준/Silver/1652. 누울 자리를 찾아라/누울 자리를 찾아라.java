import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int galo = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '.') count++;
                else {
                    if (count >= 2) galo++;
                    count = 0;
                }
            }
            if (count >= 2) galo++;
        }
        int selo = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == '.') count++;
                else {
                    if (count >= 2) selo++;
                    count = 0;
                }
            }
            if (count >= 2) selo++;
        }
        System.out.println(galo + " " + selo);

        br.close();
    }
}