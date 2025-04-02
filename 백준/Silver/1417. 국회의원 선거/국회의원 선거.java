import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) max = arr[i];
        }
        int init = arr[0];

        while (max >= arr[0]) {
            for (int i = 1; i < N; i++) { // 최댓값 찾기
                if (max == arr[i]) {
                    arr[i]--;
                    arr[0]++;
                    if (arr[0] > max) break;
                }
            }
            max--;
        }
        System.out.println(arr[0] - init);
        br.close();
    }
}