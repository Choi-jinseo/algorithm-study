import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr.add(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String C = st.nextToken();
                if (C.equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = x; j < x + y; j++) {
                        arr.add(j, st.nextToken());
                    }
                } else if (C.equals("D")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        arr.remove(x);
                    }
                } else { // A
                    int y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        arr.add(st.nextToken());
                    }
                }
            }
            sb.append("#").append(t+1);
            for (int j = 0; j < 10; j++) {
                sb.append(" ").append(arr.get(j));
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
