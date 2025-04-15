import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());

        HashSet<Integer> hs = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NA; i++) {
            hs.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < NB; i++) {
            if (hs.contains(Integer.parseInt(st.nextToken()))) count++;
        }
        System.out.println(NA + NB - count * 2);
        br.close();
    }
}