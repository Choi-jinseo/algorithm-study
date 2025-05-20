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
                st.nextToken(); // | 버리기
                int idx = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                ArrayList<String> brr = new ArrayList<>();
                for (int k = 0; k < idx; k++) {
                    brr.add(arr.get(k));
                }
                for (int j = 0; j < K; j++) {
                    brr.add(st.nextToken());
                }
                for (int j = idx; j < arr.size(); j++) {
                    brr.add(arr.get(j));
                }
                arr = brr;
            }
            sb.append("#").append(t+1);
            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(arr.get(i));
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
