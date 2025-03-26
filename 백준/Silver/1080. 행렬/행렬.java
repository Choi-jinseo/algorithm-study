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

        int[][] arr = new int[N][M];
        int[][] brr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                brr[i][j] = str.charAt(j) - '0';
            }
        }

        if (N < 3 || M < 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != brr[i][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                // 3*3 교환
                if (arr[i][j] != brr[i][j]) {
                    for (int k = i; k <= i+2; k++) {
                        for (int l = j; l <= j+2; l++) {
                            if (arr[k][l] == 0) arr[k][l] = 1;
                            else arr[k][l] = 0;
                        }
                    }
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != brr[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
