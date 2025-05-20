import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[7];
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] brr = new int[35];
            int idx = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = i+1; j < 7; j++) {
                    for (int k = j+1; k < 7; k++) {
                        brr[idx] = arr[i] + arr[j] + arr[k];
                        idx++;
                    }
                }
            }
            for (int i = 0; i < 35; i++) {
                for (int j = 1; j < 35; j++) {
                    if (brr[j-1] < brr[j]) {
                        int temp = brr[j - 1];
                        brr[j - 1] = brr[j];
                        brr[j] = temp;
                    }
                }
            }
            int count = 1;
            int answer = brr[0];
            for (int i = 0; i < 34; i++) {
                if (brr[i] != brr[i+1]) {
                    count++;
                    if (count == 5) {
                        answer = brr[i+1];
                        break;
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
