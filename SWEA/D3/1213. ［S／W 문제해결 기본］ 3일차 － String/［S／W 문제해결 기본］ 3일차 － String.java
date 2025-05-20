import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int t = 0; t < T; t++) {
            int tc = Integer.parseInt(br.readLine());
            String sub = br.readLine();
            String str = br.readLine();
            int count = 0;
            for (int i = 0; i <= str.length() - sub.length(); i++) {
                if (str.charAt(i) == sub.charAt(0)) { // 비교 시작
                    boolean flag = false;
                    for (int j = 0; j < sub.length(); j++) {
                        if (str.charAt(i + j) != sub.charAt(j)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) count++;
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
