import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[56];
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = M - 1; j >= 0; j--) {
                    if (str.charAt(j) == '1' && !flag) {
                        for (int k = 0; k < 56; k++) {
                            arr[k] = str.charAt(j - 55 + k) - '0';
                        }
                        flag = true;
                        break;
                    }
                }
            }
            int one = 0;
            int two = 0;
            for (int i = 0; i < 56; i+=7) {
                String temp = "";
                int num = 0;
                for (int j = 0; j < 7; j++) {
                    temp += arr[i + j];
                }
                if (temp.equals("0001101")) num = 0;
                else if (temp.equals("0011001")) num = 1;
                else if (temp.equals("0010011")) num = 2;
                else if (temp.equals("0111101")) num = 3;
                else if (temp.equals("0100011")) num = 4;
                else if (temp.equals("0110001")) num = 5;
                else if (temp.equals("0101111")) num = 6;
                else if (temp.equals("0111011")) num = 7;
                else if (temp.equals("0110111")) num = 8;
                else if (temp.equals("0001011")) num = 9;

                if (i % 14 == 0) one += num;// 홀수
                else two += num;
            }
            int answer = one * 3 + two;
            sb.append("#").append(t+1).append(" ");
            if (answer % 10 == 0) sb.append(one + two);
            else sb.append(0);
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
