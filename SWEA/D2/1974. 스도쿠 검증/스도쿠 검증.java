import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean flag = false;
            for (int i = 0; i < 9; i++) {
                HashSet<Integer> hs = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    hs.add(arr[i][j]);
                }
                if (hs.size() != 9) {
                    flag = true;
                    break;
                }
            }
            if (!flag) for (int i = 0; i < 9; i++) {
                HashSet<Integer> hs = new HashSet<>();
                for (int j = 0; j < 9; j++) {
                    hs.add(arr[j][i]);
                }
                if (hs.size() != 9) {
                    flag = true;
                    break;
                }
            }
            if (!flag) for (int i = 0; i < 9; i+=3) {
                for (int j = 0; j < 9; j+=3) {
                    // 3*3의 시작 위치
                    HashSet<Integer> hs = new HashSet<>();
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            hs.add(arr[k][l]);
                        }
                    }
                    if (hs.size() != 9) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (!flag) sb.append("#").append(t + 1).append(" ").append(1).append('\n');
            else sb.append("#").append(t + 1).append(" ").append(0).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
