import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 끊어진 기타줄
        int N = Integer.parseInt(st.nextToken());
        // 브랜드 수
        int M = Integer.parseInt(st.nextToken());

        // 최소 패키지 가격
        int minP = 1000;
        // 최소 낱개 가격
        int minQ = 1000;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            if (P < minP) {
                minP = P;
            }
            int Q = Integer.parseInt(st.nextToken());
            if (Q < minQ) {
                minQ = Q;
            }
        }
        // 패키지로만 샀을때 가격
        int onlyP = (N + 5) / 6 * minP;
        // 낱개로만 샀을때 가격
        int onlyQ = N * minQ;
        // 패키지로는 N/6 개 사고, 남은 기타줄은 낱개로 사는 경우
        int PQ = (N / 6) * minP + (N % 6) * minQ;
        
        // 최소가격 비교
        int[] arr = {onlyP, onlyQ, PQ};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
        br.close();
    }
}