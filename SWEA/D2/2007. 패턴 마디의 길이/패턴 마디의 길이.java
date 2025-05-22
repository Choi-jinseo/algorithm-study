import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            String sub = "";
            int answer = 0;
            for (int i = 0; i < str.length(); i++) {
                sub += str.charAt(i); // 부분 문자열
                boolean flag = false;
                for (int j = i+1; j < str.length(); j+=(i+1)) {
                    for (int k = 0; k < i+1 && j+k < str.length(); k++) {
                        if (sub.charAt(k) != str.charAt(j+k)) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
                if (!flag) {
                    answer = i+1;
                    break;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}