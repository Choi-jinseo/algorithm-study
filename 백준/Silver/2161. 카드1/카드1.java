import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(deque.pollFirst()).append(" ");
            if (!deque.isEmpty()) {
                deque.addLast(deque.pollFirst());
            }
        }

        System.out.println(sb);

        br.close();
    }
}