import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 색종이 수
        int[][] arr = new int[100][100];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 색종이 시작 x좌표
            int y = Integer.parseInt(st.nextToken()); // 색종이 시작 y좌표
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }
        System.out.println(Arrays.stream(arr).flatMapToInt(row -> Arrays.stream(row)).sum());
        br.close();
    }
}