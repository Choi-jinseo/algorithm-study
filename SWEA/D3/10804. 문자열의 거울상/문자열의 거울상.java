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
                arr[i] = str.charAt(arr.length - 1 - i);
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'b') arr[i] = 'd';
                else if (arr[i] == 'd') arr[i] = 'b';
                else if (arr[i] == 'p') arr[i] = 'q';
                else if (arr[i] == 'q') arr[i] = 'p';
            }
            sb.append("#").append(t+1).append(" ");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}