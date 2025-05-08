import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[100];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 100; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()) - 1;
            if (N % 3 == 1) {
                for (int i = 0; i <= N; i++) {
                    if (i % 3 == 1) sb.append('A');
                    else sb.append('B');
                }
                sb.append('\n');
            }
            else if (N % 3 == 2) {
                for (int i = 0; i <= N; i++) {
                    if (i % 3 == 2) sb.append('A');
                    else sb.append('B');
                }
                sb.append('\n');
            }
            else sb.append("impossible").append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}