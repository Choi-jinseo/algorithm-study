import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] arr = new int['Z'-'A'+1];
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)-'A']++;
            }
            int x = 0; // 알파벳 종류 수
            boolean y = true; // 2번 등장 여부
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    x++;
                    if (arr[i] != 2) {
                        y = false;
                        break;
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ");
            if (x == 2 && y) sb.append("Yes");
            else sb.append("No");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}