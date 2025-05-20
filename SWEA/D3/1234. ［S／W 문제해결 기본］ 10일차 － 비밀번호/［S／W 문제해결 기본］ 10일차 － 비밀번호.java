import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            String str = st.nextToken();
            for (int i = 0; i < N; i++) {
                arr.add(str.charAt(i) - '0');
            }
            boolean flag = false;
            while (!flag) {
                flag = true;
                for (int i = 0; i < arr.size() - 1; i++) {
                    if (arr.get(i) == arr.get(i+1)) {
                        flag = false;
                        arr.remove(i);
                        arr.remove(i);
                    }
                }
            }
            String answer = "";
            for (int i : arr) {
                answer += i;
            }
            sb.append("#").append(t+1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
