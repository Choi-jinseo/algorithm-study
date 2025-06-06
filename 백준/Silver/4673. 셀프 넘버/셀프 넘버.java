import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10001];
        for (int i = 1; i <= 10000; i++) {
            int num = i;
            int sum = i;
            while(num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            if (sum <= 10000) arr[sum] = 1;
        }
        for (int i = 1; i <= 10000; i++) {
            if (arr[i] == 0) sb.append(i).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}