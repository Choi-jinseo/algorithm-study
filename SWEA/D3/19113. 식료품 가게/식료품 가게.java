import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> answer = new ArrayList<>();
            int[] arr = new int[N + N];
            for (int i = 0; i < N + N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N + N; i++) {
                if (arr[i] == 0) continue;
                int num = arr[i];
                answer.add(num);
                for (int j = i; j < N + N; j++) {
                    if (arr[j] == (num / 3) * 4) {
                        arr[j] = 0;
                        break;
                    }
                }
            }
            sb.append("#").append(t+1).append(" ");
            for (Integer i : answer) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}