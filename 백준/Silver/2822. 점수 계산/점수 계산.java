import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[8];
        int[] idx = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            idx[i] = i + 1;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 8 - i; j++) {
                if (arr[j-1] < arr[j]) {
                    int arrTmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = arrTmp;

                    int idxTmp = idx[j-1];
                    idx[j-1] = idx[j];
                    idx[j] = idxTmp;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 5-i; j++) {
                if (idx[j-1] > idx[j]) {
                    int idxTmp = idx[j-1];
                    idx[j-1] = idx[j];
                    idx[j] = idxTmp;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 5; i++) {
            count += arr[i];
        }
        System.out.println(count);
        for (int i = 0; i < 5; i++) {
            System.out.print(idx[i] + " ");
        }

        br.close();
    }
}