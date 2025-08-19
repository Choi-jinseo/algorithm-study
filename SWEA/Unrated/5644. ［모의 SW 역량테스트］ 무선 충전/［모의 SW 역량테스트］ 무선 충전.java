import java.io.*;
import java.util.*;

public class Solution {
    static int[][] d = {{0,0},{-1,0},{0,1},{1,0},{0,-1}}; // -,상,우,하,좌
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 총 이동시간
            int A = Integer.parseInt(st.nextToken()); // BC 의 수
            int[] moveA = new int[M+1];
            int[] moveB = new int[M+1];

            int[][][] cost = new int[10][10][A]; // 10*10 map 인데 좌표에 BC정보가 들어갈것임
            // moveA[0], moveB[0] 은 0으로 해서 처음 시작지점에서는 d[0](안움직인다)상태에서 충전시킴
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveB[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                // 문제가 x y 가 반대라 조정해서 받기
                int y = Integer.parseInt(st.nextToken())-1; // y
                int x = Integer.parseInt(st.nextToken())-1; // x
                int C = Integer.parseInt(st.nextToken()); // C
                int P = Integer.parseInt(st.nextToken()); // P

                int s = 0;
                for (int j = x-C; j <= x+C; j++) {
                    for (int k = y-s; k <= y+s; k++) {
                        if (0<=j && j<10 && 0<=k && k<10) { // 10*10 배열 넘어가는지 체크
                            cost[j][k][i] = P;
                        }
                    }
                    if (j < x) s++;
                    else s--;
                }
            }

            int ax = 0, ay = 0;
            int bx = 9, by = 9;

            int sum = 0;
            for (int i = 0; i <= M; i++) { // 해당 좌표에서
                // i: 0 에서는 안움직이도록 초기화 해놨음
                ax = ax + d[moveA[i]][0];
                ay = ay + d[moveA[i]][1];

                bx = bx + d[moveB[i]][0];
                by = by + d[moveB[i]][1];

                int maxA = 0;
                int maxB = 0;
                int maxAIdx = 0;
                int maxBIdx = 0;
                for (int j = 0; j < A; j++) { // 모든 BC 에 대해
                    // A,B의 최대P BC 찾기
                    if (maxA < cost[ax][ay][j]) {
                        maxA = cost[ax][ay][j];
                        maxAIdx = j;
                    }
                    if (maxB < cost[bx][by][j]) {
                        maxB = cost[bx][by][j];
                        maxBIdx = j;
                    }
                }
                if (maxAIdx != maxBIdx) { // 다르면 각자 할당받으면 됨
                    sum += maxA + maxB;
                } else { // 같다면
                    if (maxA == 0 && maxB == 0) continue; // 0이면 둘다 아무것도 할당 못받음
                    // 두번째로 큰 P의 BC
                    int maxA2 = 0;
                    int maxB2 = 0;
                    int maxA2Idx = 0;
                    int maxB2Idx = 0;
                    for (int j = 0; j < A; j++) { // 다시 BC 탐색
                        if (j == maxAIdx) continue; // 최대는 제외함
                        if (maxA2 < cost[ax][ay][j]) {
                            maxA2 = cost[ax][ay][j];
                            maxA2Idx = j;
                        }
                    }
                    for (int j = 0; j < A; j++) { // 다시 BC 탐색
                        if (j == maxBIdx) continue; // 최대는 제외함
                        if (maxB2 < cost[bx][by][j]) {
                            maxB2 = cost[bx][by][j];
                            maxB2Idx = j;
                        }
                    }
                    // 현재 A,B의 최대P BC 가 중복되었을때임
                    // "A의 최대P + B의 2번째P, A의 2번째P + B의 최대P" 중 큰 값이 선택됨
                    sum += Math.max(maxA + maxB2, maxA2 + maxB);
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}