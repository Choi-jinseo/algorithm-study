import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       

        int x = Integer.parseInt(br.readLine());

        int[] arr = {64,32,16,8,4,2,1};
        int sum = 0;
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= x) {
                sum += arr[i];
                num++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        System.out.println(sb);
        br.close();
    }
}