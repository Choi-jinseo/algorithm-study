import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[51];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[input]++;
        }

        int num = -1;
        for (int i = 0; i <= 50; i++) {
            if (arr[i] == i) num = i;
        }
        System.out.println(num);

        br.close();
    }
}