import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] worm;
    static boolean[] visited;
    static long min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            worm = new int[N][2]; // 지렁이 들의 좌표
            visited = new boolean[N]; // 출발 지렁이

            min = (((long)200000*200000 + (long)200000*200000)) * (N/2);
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                worm[i][0] = Integer.parseInt(st.nextToken());
                worm[i][1] = Integer.parseInt(st.nextToken());
            }
            combination(0, 0);
            sb.append("#").append(t).append(" ").append(min).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
    static void combination(int start, int cnt) { // 현재까지 선택한 쌍의 수, 누적된 벡터의 방향 합
        if (cnt == N/2) {
            long sumX = 0, sumY = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sumX += worm[i][0];
                    sumY += worm[i][1];
                } else {
                    sumX -= worm[i][0];
                    sumY -= worm[i][1];
                }
            }
            min = Math.min(min, sumX*sumX + sumY*sumY);
        } else for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i+1, cnt+1);
            visited[i] = false;
        }
    }
}