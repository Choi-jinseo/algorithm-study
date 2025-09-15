import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] shuffle = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < (N+1)/2; i++) {
                shuffle[i*2] = st.nextToken();
            }
            for (int i = 0; i < N-(N+1)/2; i++) {
                shuffle[i*2+1] = st.nextToken();
            }
            sb.append("#").append(t);
            for (int i = 0; i < N; i++) {
                sb.append(" ").append(shuffle[i]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
