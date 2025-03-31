import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][];
        String str = "";
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (i == 0) {
                for (int j = 0; j < N; j++) {
                    arr[j] = new int[str.length()];
                }
            }
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = j;
                for (int k = j - 1; k >= 0; k--) {
                    if (str.charAt(j) == str.charAt(k)) arr[i][j] = arr[i][k];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean flag = true;
                for (int k = 0; k < str.length(); k++) {
                    if (arr[i][k] != arr[j][k]) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}