import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Character> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int k = Integer.parseInt(st.nextToken());
                for (int j = 0; j < k; j++) {
                    arr.add(c);
                }
            }
            sb.append("#").append(t + 1).append('\n');
            for (int i = 0; i < arr.size(); i+=10) {
                for (int j = i; j < i + 10 && j < arr.size(); j++) {
                    sb.append(arr.get(j));
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}