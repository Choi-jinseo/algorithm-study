import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int min = A.length();
        for (int i = 0; i <= B.length()- A.length(); i++) { // i 는 옮긴거리
            int count = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j+i)) {
                    count++;
                }
            }
            if (count < min) min = count;
        }
        System.out.println(min);

        br.close();
    }
}
