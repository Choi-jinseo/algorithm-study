/**
 * 아이디어:
 *  1. 아기 상어의 위치에서 먹을 수 있는 물고기를 찾는다.
 *  2. 갈 수 있으면 진행한다.
 *      2.1. 갈 수 있는 물고기들을 bfs 로 찾는다.
 *      2.2. 처음 찾은 물고기의 depth 와 동일한 물고기들만 찾는다.
 *      2.3. 그 물고기들 중 가장 위쪽이면서, 왼쪽인 물고기를 찾는다.
 *      2.4. 그 물고기로 이동한다.
 *      2.5. 3이 될때까지 1,2 를 반복한다
 *  3. 갈 수 없거나 더 이상 물고기가 없으면 종료한다(엄마를 찾는다).
 * 
 * 메모리:
 * 시간:
 * 난이도: ★★★☆☆
 */

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] shark = new int[3]; // 상어 위치
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    shark[2] = 2; // 상어 크기
                    map[i][j] = 0; // 상어 위치를 저장했으니, map에는 빈공간으로 표시하기
                }
            }
        }
        
        int time = 0;
        int cnt = 0; // 커지기 위해 먹을 물고기 수
        while (true) {
            // 물고기를 찾고, 갈 수 있으면 가서 먹기
            int[] target = search(shark);
            if (target[0] == 20) break;
            // 이동 후 상어 위치 갱신
            shark[0] = target[0];
            shark[1] = target[1];
            // 이동 시간 증가
            time += target[2];
            cnt++;
            if (cnt == shark[2]) { // 상어 크기 만큼 먹었으면, 상어 크기 증가
                cnt = 0; // 먹을 물고기 수
                shark[2]++; // 상어 크기
            }
            map[target[0]][target[1]] = 0; // 먹은 물고기 없애기
        }
        System.out.println(time);
        br.close();
    }
    static int[] search(int[] shark) {
        int[] target = {20}; // 처음엔 갈 수 있는 물고기가 없다고 설정
        int stopDepth = Integer.MAX_VALUE;

        // bfs
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[] {shark[0], shark[1], 0}); // x, y, 이동거리(depth)
        visited[shark[0]][shark[1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];
            if (stopDepth < depth) break; // 최소 도달거리인 물고기 들만 비교해야 함
            if (map[x][y] != 0 && map[x][y] < shark[2]) { // 상어보다 작은 물고기에 도달했다면
                stopDepth = depth; // 이동거리(depth) 제한 설정
                if (target[0] > x) { // x가 더 위면
                    target = cur;
                } else if (target[0] == x) { // 높이가 같은 경우
                    if (target[1] > y) { // y가 더 왼쪽이면
                        target = cur;
                    }
                }
            }
            for (int i = 0; i < 4; i++) { // 4방 이동
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] <= shark[2]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, depth + 1});
                }
            }
        }
        return target;
    }

    static boolean isIn(int x, int y) {
        return 0<=x && x<N && 0<=y && y<N;
    }
}
