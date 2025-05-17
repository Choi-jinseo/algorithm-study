import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            char[] arr = new char[str.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = str.charAt(i);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                for (int j = 0; j < arr.length; j++) {
                    if (i == j || arr[j] == 0) continue;
                    if (str.charAt(i) == str.charAt(j)) {
                        arr[i] = 0;
                        arr[j] = 0;
                        break;
                    }
                }
            }
            ArrayList<Character> answer = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) answer.add(arr[i]);
            }
            sb.append("#").append(t+1).append(" ");
            if (answer.isEmpty()) sb.append("Good");
            else {
                Collections.sort(answer);
                for (char c : answer) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}