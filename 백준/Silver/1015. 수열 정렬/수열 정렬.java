import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // A = {2.0 3.1 1.2}
        // A = {1.2 2.0 3.1} // A.b 로 정렬
        // I = {2 0 1} // A 정렬 수행시 인덱스
        // P[I[i]] = i

        // B[p[2]] = 1 A[2]
        // B[p[0]] = 2 A[0]
        // B[p[1]] = 3 A[1]

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] P = new int[N];
        int[] I = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            I[i] = i;
        }

        for (int i = N; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;

                    temp = I[j];
                    I[j] = I[j+1];
                    I[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            P[I[i]] = i;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }

        br.close();
    }
}