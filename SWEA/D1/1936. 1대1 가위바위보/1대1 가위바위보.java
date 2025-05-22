import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        char answer = 0;
        if (A == 1) {
            if (B == 2) answer = 'B';
            else if (B == 3) answer = 'A';
        } else if (A == 2) {
            if (B == 1) answer = 'A';
            else if (B == 3) answer = 'B';
        } else {
            if (B == 1) answer = 'B';
            else if (B == 2) answer = 'A';
        }
        sb.append(answer);
        System.out.print(sb);
        br.close();
    }
}