import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int[] idx = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int exam1 = Integer.parseInt(st.nextToken());
                int exam2 = Integer.parseInt(st.nextToken());
                int hw = Integer.parseInt(st.nextToken());
                arr[i] = exam1 * 35 + exam2 * 45 + hw * 20;
                idx[i] = i;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N - i; j++) {
                    if (arr[j] > arr[j-1]) {
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;

                        temp = idx[j];
                        idx[j] = idx[j-1];
                        idx[j-1] = temp;
                    }
                }
            }
            int num;
            String answer = "";
            for (int i = 0; i < N; i++) {
                if (idx[i] == K - 1) {
                    num = i / (N / 10);
                    switch (num) {
                        case 0:
                            answer = "A+";
                            break;
                        case 1:
                            answer = "A0";
                            break;
                        case 2:
                            answer = "A-";
                            break;
                        case 3:
                            answer = "B+";
                            break;
                        case 4:
                            answer = "B0";
                            break;
                        case 5:
                            answer = "B-";
                            break;
                        case 6:
                            answer = "C+";
                            break;
                        case 7:
                            answer = "C0";
                            break;
                        case 8:
                            answer = "C-";
                            break;
                        case 9:
                            answer = "D0";
                            break;
                        default:
                            answer = "error";
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