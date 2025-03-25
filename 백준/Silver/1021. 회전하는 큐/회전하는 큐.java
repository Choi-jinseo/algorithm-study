import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 숫자 개수

        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int K = Integer.parseInt(st.nextToken()); // 뽑을 수
            int index = 0;
            for (int j = 0; j < queue.size(); j++) {
                if (queue.get(j) == K) {
                    index = j;
                    break;
                }
            }
            if (index <= queue.size() / 2) {
                for (int j = 0; j < index; j++) {
                    queue.add(queue.get(0));
                    queue.remove(0);
                    count++;
                }
            }
            else {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = index; j < queue.size(); j++) {
                    temp.add(queue.get(j));
                    count++;
                }
                for (int j = 0; j < index; j++) {
                    temp.add(queue.get(j));
                }
                queue = temp;
            }
            queue.remove(0);
        }
        System.out.println(count);
        br.close();
    }
}