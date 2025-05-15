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
            for (int i = 0; i < arr.length; i++) {
                arr[i] = str.charAt(i) - '0';
            }
            sb.append("#").append(t+1).append(" ");

            // 최솟값
            String temp = "";
            for (int i = 0; i < arr.length; i++) {
                int min = arr[i];
                int idx = i;
                for (int j = i+1; j < arr.length; j++) {
                    if (i == 0) {
                        if (min >= arr[j] && arr[j] != 0) {
                            min = arr[j];
                            idx = j;
                        }
                    }
                    else {
                        if (min >= arr[j]) {
                            min = arr[j];
                            idx = j;
                        }
                    }
                }
                if (min != arr[i]) { // 교체해야함
                    for (int j = 0; j < arr.length; j++) {
                        if (j == i) temp += arr[idx];
                        else if (j == idx) temp += arr[i];
                        else temp += arr[j];
                    }
                    break;
                }
            }
            if (temp.equals("")) temp = str; // 그대로
            sb.append(temp).append(" ");

            // 최댓값
            temp = "";
            for (int i = 0; i < arr.length; i++) {
                int max = arr[i];
                int idx = i;
                for (int j = i+1; j < arr.length; j++) {
                    if (max <= arr[j]) {
                        max = arr[j];
                        idx = j;
                    }
                }
                if (max != arr[i]) { // 교체해야함
                    for (int j = 0; j < arr.length; j++) {
                        if (j == i) temp += arr[idx];
                        else if (j == idx) temp += arr[i];
                        else temp += arr[j];
                    }
                    break;
                }
            }
            if (temp.equals("")) temp = str; // 그대로
            sb.append(temp).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}