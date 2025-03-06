import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[100000];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == 0 && !stack.empty()) arr[i] = -stack.pop();
            else stack.push(arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

        br.close();
    }
}