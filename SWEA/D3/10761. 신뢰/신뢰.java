import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] command = new int[N + N];
            for (int i = 0; i < N + N; i+=2) {
                command[i] = st.nextToken().charAt(0);
                command[i + 1] = Integer.parseInt(st.nextToken());
            }
            int lO = 1;
            int lB = 1;
            int turn = command[0];
            int temp = 0;
            int answer = 0; // 최종적으로 흐른 시간
            for (int i = 0; i < N + N; i+=2) {
                boolean change = turn != command[i];
                turn = command[i];
                if (command[i] == 'O') { // O 차례
                    if (!change) {
                        temp += Math.abs(command[i + 1] - lO) + 1;
                        answer += Math.abs(command[i + 1] - lO) + 1;
                    }
                    else {
                        temp = Math.abs(command[i + 1] - lO) + 1 - temp;
                        if (temp <= 0) temp = 1;
                        answer += temp;
                    }
                    lO = command[i + 1];
                }
                else { // B 차례
                    if (!change) {
                        temp += Math.abs(command[i + 1] - lB) + 1;
                        answer += Math.abs(command[i + 1] - lB) + 1;
                    }
                    else {
                        temp = Math.abs(command[i + 1] - lB) + 1 - temp;
                        if (temp <= 0) temp = 1;
                        answer += temp;
                    }
                    lB = command[i + 1];
                }
            }
            sb.append("#").append(t + 1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}