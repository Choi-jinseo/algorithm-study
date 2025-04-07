import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());

        TreeSet<Integer> TA = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NA; i++) {
            TA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NB; i++) {
            int b = Integer.parseInt(st.nextToken());
            TA.remove(b);
        }

        sb.append(TA.size()).append('\n');
        for (int a : TA) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}