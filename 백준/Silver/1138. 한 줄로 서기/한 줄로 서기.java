import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i == 0) {
                arr[num] = i + 1;
            }
            else {
                for (int j = 0; j < N; j++) {
                    if (arr[j] == 0) {
                        if (num == 0) {
                            arr[j] = i + 1;
                            break;
                        }
                        else num--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
}
