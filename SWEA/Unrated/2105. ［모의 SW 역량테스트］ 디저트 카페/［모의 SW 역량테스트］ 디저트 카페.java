import java.io.*;
import java.util.*;

public class Solution {
    static int[][] d = {{1,-1},{1,1},{-1,1},{-1,-1}}; // 좌하, 우하, 우상, 좌상
    static int N;
    static int[][] cafe;
    static HashSet<Integer> set;
    static int[] length;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // N*N 지역
            cafe = new int[N][N]; // 카페의 각 좌표 정보
            set = new HashSet<>();
            length = new int[4]; // 마름모의 좌하, 우하, 우상, 좌상변 길이
            max = -1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int dx = i + d[0][0];
                    int dy = j + d[0][1];
                    if (valid(dx,dy)) { // 좌하로 갈 수 있다면
                        set.add(cafe[i][j]);
                        dfs(dx,dy,0); // 현재 좌표, 현재 방향
                        set.remove(cafe[i][j]);
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(max).append('\n');
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y, int di) {
        set.add(cafe[x][y]);
        length[di]++;
        int dx1 = x + d[di][0];
        int dy1 = y + d[di][1];
        int dx2 = x + d[(di+1)%4][0];
        int dy2 = y + d[(di+1)%4][1];
        if (di < 2) { // di: 0, 1
            if (valid(dx1,dy1)) dfs(dx1,dy1,di);
            if (valid(dx2,dy2)) dfs(dx2,dy2,di+1);
        }
        else { // di: 2 ,3
            if (set.size() == (length[0]+length[1])*2) max = Math.max(max, set.size());
            else if (length[di] < length[di-2] && valid(dx1,dy1)) dfs(dx1,dy1,di);
            else if (length[di] == length[di-2] && valid(dx2,dy2)) dfs (dx2,dy2,di+1);
        }
        set.remove(cafe[x][y]);
        length[di]--;
    }
    static boolean valid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N && !set.contains(cafe[x][y]);
    }
}