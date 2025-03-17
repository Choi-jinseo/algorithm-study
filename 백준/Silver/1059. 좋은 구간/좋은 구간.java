import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        // arr 정렬
        for (int i = 0; i < L - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < L; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        int count = 0;
        if (arr[0] > n) {
            count = n * (arr[0] - n);
            count--;
        }
        else {
            for (int i = 1; i < L; i++) {
             if (arr[i - 1] < n && n < arr[i]) {
                    count += (n - arr[i - 1]) * (arr[i] - n);
                    count--;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}