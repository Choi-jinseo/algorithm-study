import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            while (M > 0) {
                if (M % 2 == 0) arr.add(0);
                else arr.add(1);
                M /= 2;
            }
            sb.append("#").append(t + 1).append(" ");
            if (N > arr.size()) sb.append("OFF");
            else {
                boolean flag = false;
                for (int i = 0; i < N; i++) {
                    if (arr.get(i) != 1) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) sb.append("ON");
                else sb.append("OFF");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}