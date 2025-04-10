import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        int[][] brr = new int[R - 2][C - 2];
        int[] nine = new int[9];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < R-1; i++) {
            for (int j = 1; j < C-1; j++) {
                int x = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j+1; l++) {
                        nine[x] = arr[k][l];
                        x++;
                    }
                }
                for (int k = 1; k < 9; k++) {
                    for (int l = 0; l < 9 - k; l++) {
                        if (nine[l] > nine[l+1]) {
                            int temp = nine[l];
                            nine[l] = nine[l+1];
                            nine[l+1] = temp;
                        }
                    }
                }
                brr[i-1][j-1] = nine[4];
            }
        }

        int count = 0;
        for (int i = 0; i < R-2; i++) {
            for (int j = 0; j < C-2; j++) {
                if (T <= brr[i][j]) count++;
            }
        }
        System.out.println(count);

        br.close();
    }
}