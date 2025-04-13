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
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(N);

        for (int i = N - 1; i > 0; i--) {
            deque.addFirst(i);
            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.pollLast());
            }
        }
        for (Integer i: deque) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
}