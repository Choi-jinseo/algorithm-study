import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] brr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

//      내림차순 정렬된 brr * 오름차순 정렬된 arr 가 S의 최솟값이다.
        for (int i = 0; i < n; i++) {
            int max = brr[i];
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (max < brr[j]) {
                    max = brr[j];
                    maxIndex = j;
                }
            }
            swap(brr, i, maxIndex);
        }
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * brr[i];
        }
        System.out.println(sum);
    }
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}