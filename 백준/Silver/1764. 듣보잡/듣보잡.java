import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> hset = new HashSet<>();
        Set<String> tset = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            hset.add(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (hset.contains(name)) tset.add(name);
        }
        
        System.out.println(tset.size());
        for (String name : tset) {
            System.out.println(name);
        }

        br.close();
    }
}