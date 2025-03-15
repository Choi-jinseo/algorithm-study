import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 포켓몬 번호
        int M = Integer.parseInt(st.nextToken()); // 문제의 개수

        HashMap<String, Integer> nameToIndex = new HashMap<>();
        HashMap<Integer, String> indexToname = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            nameToIndex.put(s, i);
            indexToname.put(i, s);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (nameToIndex.containsKey(s)) System.out.println(nameToIndex.get(s));
            else System.out.println(indexToname.get(Integer.parseInt(s)));
        }
    }
}