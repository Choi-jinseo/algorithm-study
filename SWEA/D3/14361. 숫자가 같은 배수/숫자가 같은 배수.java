import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int N = Integer.parseInt(str);
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr.length - i; j++) {
                    if (arr[j-1] > arr[j]) {
                        int temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            boolean flag1 = false;
            for (int i = N + N; i < Math.pow(10, str.length()); i += N) {
                String sub = Integer.toString(i);
                int[] brr = new int[str.length()];
                for (int j = 0; j < brr.length; j++) {
                    brr[j] = sub.charAt(j) - '0';
                }
                for (int j = 0; j < brr.length; j++) {
                    for (int k = 1; k < brr.length - j; k++) {
                        if (brr[k-1] > brr[k]) {
                            int temp = brr[k - 1];
                            brr[k - 1] = brr[k];
                            brr[k] = temp;
                        }
                    }
                }
                boolean flag2 = false;
                for (int j = 0; j < brr.length; j++) {
                    if (brr[j] != arr[j]) {
                        flag2 = true;
                        break;
                    }
                }
                if (!flag2) {
                    flag1 = true;
                    break;
                }
            }
            sb.append("#").append(t+1).append(" ");
            if (flag1) sb.append("possible");
            else sb.append("impossible");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}