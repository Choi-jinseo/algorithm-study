import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> bookCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!bookCount.containsKey(str)) bookCount.put(str, 1);
            else bookCount.put(str, bookCount.get(str) + 1);
        }

        int max = 0;
        TreeMap<String, Integer> tm = new TreeMap<>();
        for (String key : bookCount.keySet()) {
            if (bookCount.get(key) == max) tm.put(key, 0);
            else if (bookCount.get(key) > max) {
                max = bookCount.get(key);
                tm.clear();
                tm.put(key, 0);
            }
        }

        for (String key : tm.keySet()) {
            System.out.println(key);
            break;
        }

        br.close();
    }
}