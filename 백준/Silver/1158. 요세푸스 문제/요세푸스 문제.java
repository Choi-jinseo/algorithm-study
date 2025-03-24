import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        sb.append("<");
        int cursor = K-1;
        for (int i = 0; i < N-1; i++) {
            if (cursor < arr.size()) {
                sb.append(arr.get(cursor)).append(", ");
                arr.remove(cursor);
                cursor--;
            }
            else {
                cursor = cursor % arr.size();
                sb.append(arr.get(cursor)).append(", ");
                arr.remove(cursor);
                cursor--;
            }
            cursor += K;
        }
        sb.append(arr.get(0)).append(">");
        System.out.print(sb);
        br.close();
    }
}