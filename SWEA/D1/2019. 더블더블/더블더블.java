import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        sb.append(answer).append(" ");
        for (int i = 0; i < N; i++) {
            answer *= 2;
            sb.append(answer).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}