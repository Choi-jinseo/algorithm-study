import java.io.*;
import java.util.*;

class Solution {
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int[] arr = new int[str.length()]; // 숫자
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }
            int N = Integer.parseInt(st.nextToken()); // 교환횟수
            max = 0;
            if (arr.length == 1) max = arr[0];
            else dfs(arr, N);
            sb.append("#").append(t + 1).append(" ").append(max).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(int[] arr, int count) {
        if (count == 0) {
            int num = 0;
            for (int i = 0; i < arr.length; i++) {
                num *= 10;
                num += arr[i];
            }
            if (max < num) max = num;
            return;
        }
        else {
            boolean flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if(arr[i] <= arr[j]) {
                        flag = true;
                        int[] brr = arr.clone();
                        int temp = brr[i];
                        brr[i] = brr[j];
                        brr[j] = temp;
                        dfs(brr, count - 1);
                    }
                }
            }
            if (!flag) {
                int[] brr = arr.clone();
                int temp = brr[brr.length-2];
                brr[brr.length-2] = brr[brr.length-1];
                brr[brr.length-1] = temp;
                dfs(brr, count - 1);
            }
        }
    }
}