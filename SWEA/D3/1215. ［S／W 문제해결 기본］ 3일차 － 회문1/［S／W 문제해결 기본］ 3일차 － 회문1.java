import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[8][8];
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8 - N + 1; j++) {
                    boolean flag1 = false;
                    boolean flag2 = false;
                    for (int k = 0; k < N / 2; k++) {
                        if (arr[i][j + k] != arr[i][j + N - 1 - k]) {
                            flag1 = true;
                            break;
                        }
                    }
                    if (!flag1) count++;

                    for (int k = 0; k < N / 2; k++) {
                        if (arr[j + k][i] != arr[j + N - 1 - k][i]) {
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2) count++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}