import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] numbers;
    static int max, min;
    static int[] operCnt = new int[4];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 숫자 수
            numbers = new int[N];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            operCnt[0] = Integer.parseInt(st.nextToken()); // +
            operCnt[1] = Integer.parseInt(st.nextToken()); // -
            operCnt[2] = Integer.parseInt(st.nextToken()); // *
            operCnt[3] = Integer.parseInt(st.nextToken()); // /

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            dfs(numbers[0], 1, new int[4]);

            sb.append("#").append(t+1).append(" ").append(max-min).append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int left, int idx, int[] operUse) {
        if (idx == N) { // 숫자를 다 썼다면
            max = Math.max(max, left);
            min = Math.min(min, left);
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (operCnt[i] > operUse[i]) {
                    int[] operTemp = operUse.clone();
                    operTemp[i]++; // 해당 연산자 1개 사용
                    switch (i) {
                        case 0:
                            dfs(left+numbers[idx], idx+1, operTemp);
                            continue;
                        case 1:
                            dfs(left-numbers[idx], idx+1, operTemp);
                            continue;
                        case 2:
                            dfs(left*numbers[idx], idx+1, operTemp);
                            continue;
                        case 3:
                            dfs(left/numbers[idx], idx+1, operTemp);
                    }
                }
            }
        }
    }
}