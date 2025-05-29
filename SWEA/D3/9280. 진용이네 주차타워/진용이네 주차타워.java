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
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N]; // 주차장 요금
            int[] stateA = new int[N]; // 주차장에 주차된 차
            Arrays.fill(stateA, -1);
            int[] brr = new int[M]; // 자동차 무게
            int[] stateB = new int[M]; // 자동차가 주차된 곳
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0; // 벌어들인 금액
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                brr[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M+M; i++) { // 입,퇴장 차량 순서
                int x = Integer.parseInt(br.readLine())-1; // 차량번호
                if (x >= 0) { // 차량 입장
                    boolean flag = false;
                    for (int j = 0; j < N; j++) {
                        if (stateA[j] == -1) { // 비어있으면
                            stateA[j] = x; // j번 주차장에는 x번 차량이 주차됨
                            stateB[x] = j; // x번 차량은 j번 주차장에 주차됨
                            sum += brr[x] * arr[j];
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) { // 대기해야됨
                        queue.add(x);
                    }
                }
                else { // 차량 퇴장
                    x = (-1) * x - 2;
                    stateA[stateB[x]] = -1; // 주차장 비우기
                    if (!queue.isEmpty()) { // 대기중인 차가 있으면
                        int j = stateB[x]; // 빈 주차장
                        int y = queue.poll(); // 대기한 차
                        stateA[j] = y;
                        stateB[y] = j;
                        sum += brr[y] * arr[j];
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ").append(sum).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}