import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] edge = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[i][0] = a; // i번 전깃줄의 시작 좌표
            edge[i][1] = b; // i번 전깃줄의 도착 좌표
        }
        // 시작 좌표(a)에 대해 오름차순 정렬
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (edge[i][0] > edge[j][0]) {
                    int[] temp = edge[i];
                    edge[i] = edge[j];
                    edge[j] = temp;
                }
            }
        }
        int[] len = new int[N+1];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (len[idx] < edge[i][1]) { // b 좌표
                len[++idx] = edge[i][1];
            } else {
                // 이분탐색
                int start = 0;
                int end = idx;
                while(start < end) {
                    int mid = (start + end) / 2;
                    if (len[mid] < edge[i][1]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                len[end] = edge[i][1];
            }
        }
        System.out.println(N-idx);

        br.close();
    }
}