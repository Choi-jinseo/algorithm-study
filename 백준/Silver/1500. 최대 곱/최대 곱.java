import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 13, 8
        // 111 22222
        // S/K = 1, S%K = 5
        
        int bigNumCount = S%K;
        int smallNum = S/K;
        int bigNum = smallNum + 1;

        long answer = 1;
        for (int i = 0; i < bigNumCount; i++) {
            answer *= bigNum;
        }
        for (int i = bigNumCount; i < K; i++) {
            answer *= smallNum;
        }
        System.out.println(answer);
        br.close();
    }
}