import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 0; t < T; t++) {
            int tNum = Integer.parseInt(br.readLine());
            char[][] arr = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            int max = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 99; j++) { // 시작
                    for (int k = 2; k <= 100 - j; k++) { // 길이 설정
                        boolean flag1 = false;
                        boolean flag2 = false;
                        for (int l = 0; l < k / 2; l++) {
                            if (arr[i][j+l] != arr[i][j+k-1-l]) {
                                flag1 = true;
                                break;
                            }
                        }
                        if (!flag1) max = Math.max(max, k);
                        for (int l = 0; l < k / 2; l++) {
                            if (arr[j+l][i] != arr[j+k-1-l][i]) {
                                flag2 = true;
                                break;
                            }
                        }
                        if (!flag2) max = Math.max(max, k);
                    }
                }
            }
            sb.append("#").append(tNum).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}