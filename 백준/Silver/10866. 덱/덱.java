import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[20001];
        int fp = 10000;
        int bp = 10000;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push_front")) {
                if (arr[fp] != 0) fp--;
                arr[fp] = Integer.parseInt(st.nextToken());
            }
            if (str.equals("push_back")) {
                if (arr[bp] != 0) bp++;
                arr[bp] = Integer.parseInt(st.nextToken());
            }
            if (str.equals("pop_front")) {
                if (arr[fp] != 0) {
                    sb.append(arr[fp]).append('\n');
                    arr[fp] = 0;
                    if (fp != bp) fp++;
                } else sb.append(-1).append('\n');
            }
            if (str.equals("pop_back")) {
                if (arr[bp] != 0) {
                    sb.append(arr[bp]).append('\n');
                    arr[bp] = 0;
                    if (fp != bp) bp--;
                } else sb.append(-1).append('\n');
            }
            if (str.equals("size")) {
                int size = 0;
                if (arr[fp] != 0) size = bp - fp + 1;
                sb.append(size).append('\n');
            }
            if (str.equals("empty")) {
                if (arr[fp] == 0) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
            if (str.equals("front")) {
                if (arr[fp] != 0) sb.append(arr[fp]).append('\n');
                else sb.append(-1).append('\n');
            }
            if (str.equals("back")) {
                if (arr[bp] != 0) sb.append(arr[bp]).append('\n');
                else sb.append(-1).append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}