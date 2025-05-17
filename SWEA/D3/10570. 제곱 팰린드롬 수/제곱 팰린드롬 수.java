import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[1001][2];
        for (int i = 1; i <= Math.sqrt(1000); i++) {
            arr[i*i][0] = 1; // 확인
            arr[i*i][1] = i; // 제곱근 저장
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int i = A; i <= B; i++) {
                if (arr[i][0] == 1) { // 제곱수 확인
                    String str1 = Integer.toString(i); // 제곱수
                    String str2 = Integer.toString(arr[i][1]); // 제곱근
                    boolean flag1 = false;
                    boolean flag2 = false;
                    for (int j = 0; j < str1.length() / 2; j++) {
                        if (str1.charAt(j) != str1.charAt(str1.length() - 1 - j)) {
                            flag1 = true;
                            break;
                        }
                    }
                    for (int j = 0; j < str2.length() / 2; j++) {
                        if (str2.charAt(j) != str2.charAt(str2.length() - 1 - j)) {
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag1 && !flag2) count++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}