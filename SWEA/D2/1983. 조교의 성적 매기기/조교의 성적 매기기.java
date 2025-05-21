import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            int[] num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = i;
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int sum = 0;
                sum += Integer.parseInt(st.nextToken()) * 7;
                sum += Integer.parseInt(st.nextToken()) * 9;
                sum += Integer.parseInt(st.nextToken()) * 4;
                score[i] = sum;
            }
            // score 정렬 하면서 num 도 같이
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (score[j-1] < score[j]) {
                        int temp = score[j - 1];
                        score[j - 1] = score[j];
                        score[j] = temp;

                        temp = num[j - 1];
                        num[j - 1] = num[j];
                        num[j] = temp;
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ");
            for (int i = 0; i < N; i++) {
                if (num[i] == K-1) { // num[i] : 학생번호, i : 학생 석차
                    int grade = i / (N / 10);
                    if (grade == 0) sb.append("A+");
                    else if (grade == 1) sb.append("A0");
                    else if (grade == 2) sb.append("A-");
                    else if (grade == 3) sb.append("B+");
                    else if (grade == 4) sb.append("B0");
                    else if (grade == 5) sb.append("B-");
                    else if (grade == 6) sb.append("C+");
                    else if (grade == 7) sb.append("C0");
                    else if (grade == 8) sb.append("C-");
                    else if (grade == 9) sb.append("D0");
                    break;
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
