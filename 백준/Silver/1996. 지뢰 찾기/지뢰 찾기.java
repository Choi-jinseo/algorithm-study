import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+2][N+2];
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (str[i].charAt(j) != '.') {
                    // 8방 탐색
                    for (int k = i-1; k <= i+1; k++) {
                        for (int l = j-1; l <= j+1; l++) {
                            arr[k+1][l+1] += (str[i].charAt(j) - '0');
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (str[i].charAt(j) != '.') sb.append('*');
                else {
                    if (arr[i+1][j+1] >= 10) sb.append('M');
                    else sb.append(arr[i+1][j+1]);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}