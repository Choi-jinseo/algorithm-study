import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[8];
        ArrayList<Integer> prob = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            prob.add(num);
        }
        Collections.sort(prob);
        int temp = prob.get(2);
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (arr[i] > temp) {
                count += arr[i];
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(sb);

        br.close();
    }
}