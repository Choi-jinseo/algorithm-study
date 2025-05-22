import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        sb.append(sum);
        System.out.print(sb);
        br.close();
    }
}