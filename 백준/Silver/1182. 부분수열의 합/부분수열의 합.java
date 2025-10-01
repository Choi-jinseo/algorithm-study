import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
        br.close();
    }

    public static void dfs(int start, int sum) {
        if (start != 0 && sum == S) {
            answer++;
        }
        else if (start == N) return;
        for (int i = start; i < N; i++) {
            dfs(i+1,sum+arr[i]);
        }
    }
}