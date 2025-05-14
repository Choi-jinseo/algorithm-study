import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }
            sb.append('#').append(t+1).append(" ");
            boolean maxFlag = false;
            boolean minFlag = false;
            int min = arr[0];
            int minIdx = 0;
            for (int i = 1; i < str.length(); i++) {
                if (min >= arr[i] && arr[i] != 0) {
                    min = arr[i];
                    minIdx = i;
                }
            }
            if (min != arr[0]) {
                sb.append(arr[minIdx]);
                for (int j = 1; j < arr.length; j++) {
                    if (j == minIdx) sb.append(arr[0]);
                    else sb.append(arr[j]);
                }
                sb.append(" ");
                minFlag = true;
            }
            if (!minFlag) {
                for (int i = 1; i < str.length(); i++) {
                    min = arr[i];
                    minIdx = i;
                    for (int j = i + 1; j < str.length(); j++) {
                        if (min >= arr[j]) {
                            min = arr[j];
                            minIdx = j;
                        }
                    }
                    if (min != arr[i]) {
                        for (int j = 0; j < arr.length; j++) {
                            if (j == i) sb.append(arr[minIdx]);
                            else if (j == minIdx) sb.append(arr[i]);
                            else sb.append(arr[j]);
                        }
                        sb.append(" ");
                        minFlag = true;
                        break;
                    }
                }
                if (!minFlag) {
                    sb.append(str).append(" ");
                }
            }

            for (int i = 0; i < str.length(); i++) {
                int max = arr[i];
                int maxIdx = i;
                for (int j = i + 1; j < str.length(); j++) {
                    if (max <= arr[j]) {
                        max = arr[j];
                        maxIdx = j;
                    }
                }
                if (max != arr[i]) {
                    for (int j = 0; j < arr.length; j++) {
                        if (j == i) sb.append(arr[maxIdx]);
                        else if (j == maxIdx) sb.append(arr[i]);
                        else sb.append(arr[j]);
                    }
                    sb.append('\n');
                    maxFlag = true;
                    break;
                }
            }
            if (!maxFlag) {
                sb.append(str).append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}