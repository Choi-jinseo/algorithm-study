import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 최초 물병 수
        int K = Integer.parseInt(st.nextToken()); // 만들어야 하는 최대의 물병 수

        ArrayList<Integer> arr = new ArrayList<>();

        while (N > 0) {
            arr.add(cal(N));
            N = N - cal(N);
        }
        if (arr.size() <= K) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        for (int i = K; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        System.out.println(arr.get(K-1) - sum);

        br.close();
    }
    static int cal(int N) {
        int num = 1;
        while (num * 2 <= N) {
            num = num * 2;
        }
        return num;
    }
}