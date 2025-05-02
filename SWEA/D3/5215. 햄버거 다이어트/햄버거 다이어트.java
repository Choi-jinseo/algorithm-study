import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] arr;
    static int[] val;
    static int[] cal;
    static int max;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료 수
            K = Integer.parseInt(st.nextToken()); // 제한 칼로리
            arr = new ArrayList[N];
            val = new int[N];
            cal = new int[N];
            max = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                val[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    arr[j].add(i);
                }
            }
            for (int i = 0; i < N; i++) {
                dfs(i, val[i], cal[i]);
            }
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(int idx, int valSum, int calSum) {
        if (valSum > max) max = valSum;
        for (Integer i : arr[idx]) {
            if (calSum + cal[i] <= K) dfs(i, valSum + val[i], calSum + cal[i]);
        }
    }
}