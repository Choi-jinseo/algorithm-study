import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // x
                arr[i][1] = Integer.parseInt(st.nextToken()); // y
                arr[i][2] = Integer.parseInt(st.nextToken()); // s
            }
            int[] table = new int[N];
            sb.append("#").append(t+1).append(" ");
            for (int i = 0; i < N; i++) { // i 도시
                double max = arr[i][2]; // 위협 도시 중 최고 영향력
                int count = 0; // 최고 영향력 도시 수
                int num = 0; // 최고 영향력 도시 번호
                for (int j = 0; j < N; j++) {
                    if (j == i) continue;

                    double f = (double)arr[j][2] / (Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2)); // j 의 영향력
                    if (max < f) { // 최고 영향력 갱신
                        max = f;
                        count = 1;
                        num = j;
                    }
                    else if (max == f && max > arr[i][2]) { // 같은 영향력 도시 중복
                        count++;
                    }
                }
                if (count == 0) table[i] = -1; // K
                else if (count == 1) table[i] = num;
                else table[i] = -2; // D
            }
            for (int i = 0; i < N; i++) {
                if (table[i] == -1) sb.append('K').append(" ");
                else if (table[i] == -2) sb.append('D').append(" ");
                else { // 어떤 도시의 지배를 받는다면
                    int num = table[i];
                    while (table[num] != -1 && table[num] != -2) {
                        num = table[num];
                    }
                    sb.append(num+1).append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}