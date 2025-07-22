import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3]; // 기간 시작, 기간 끝, 금액
        max = 0; // 최대 금액 (답)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = i + 1; // 시작
            arr[i][1] = i + Integer.parseInt(st.nextToken()); // 끝
            arr[i][2] = Integer.parseInt(st.nextToken()); // 금액
        }
        for (int i = 0; i < N; i++) {
            if (arr[i][1] <= N) {
                combination(i, arr[i][2]);
            }
        }
        System.out.println(max);
        br.close();
    }
    static void combination(int i, int sum) {
        boolean flag = false;
        for (int j = i+1; j < N; j++) {
            if (arr[i][1] < arr[j][0] && arr[j][1] <= N) {
                flag = true;
                combination(j, sum + arr[j][2]);
            }
        }
        if (!flag) {
            max = Math.max(max, sum);
        }
    }
}