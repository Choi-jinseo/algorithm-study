import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < N; i++) { // 해당 빌딩
            int count = 0;
            for (int j = 0; j < i; j++) { // 왼쪽 빌딩
                boolean visible = true;
                for (int k = j + 1; k < i; k++) { // 중간 빌딩 탐색
                    if ((arr[i] - arr[j]) * (k - j) + arr[j] * (i - j) <= arr[k] * (i - j)) { // 가리면
                        visible = false;
                        break;
                    }
                }
                if (visible) count++;
            }
            for (int j = i + 1; j < N; j++) { // 오른쪽 빌딩
                boolean visible = true;
                for (int k = i + 1; k < j; k++) { // 중간 빌딩 탐색
                    if ((arr[i] - arr[j]) * (j - k) + arr[j] * (j - i) <= arr[k] * (j - i)) { // 가리면
                        visible = false;
                        break;
                    }
                }
                if (visible) count++;
            }
            if (max < count) max = count;
        }
        System.out.println(max);
        br.close();
    }
}