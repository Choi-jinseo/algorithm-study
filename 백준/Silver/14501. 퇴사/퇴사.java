/*
아이디어: 조합 (DFS)
    각 상담마다 [시작-끝]을 하나의 블럭으로 생각하고, 이들을 조합하는 방식
    가능한 조합에 해당하는 금액을 비교하여 최대 금액 구하기

메모리: 14288 KB
시간: 108 ms
난이도: ★★★☆☆
 */

import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3]; // 시작(일), 끝(일), 금액
        max = 0; // 최대 금액 (답)
        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = i + 1; // 시작(일)
            arr[i][1] = i + Integer.parseInt(st.nextToken()); // 끝(일)
            arr[i][2] = Integer.parseInt(st.nextToken()); // 금액
        }
        // 조합 찾기
        for (int i = 0; i < N; i++) {
            if (arr[i][1] <= N) { // 퇴사(일) 이전에 끝나는 상담만 유효함
                combination(i, arr[i][2]);
            }
        }
        // 정답 출력
        System.out.println(max);
        br.close();
    }
    // 시작(날)로 정렬된 배열을 바탕으로
    // 시작(날)인 (i)[시작-끝]블럭과 '오른쪽'(j)[시작-끝]블럭들로 조합한다. (탐색 중복 방지)
    static void combination(int i, int sum) {
        boolean flag = false; // 더 이상 조합할 수 없는 경우를 확인하는 변수
        for (int j = i+1; j < N; j++) {
            // 서로 겹치지 않는 [시작-끝]블럭인 경우에 조합 수행
            if (arr[i][1] < arr[j][0] && arr[j][1] <= N) {
                flag = true;
                // 조합을 만들어 가면서 sum 에 금액을 누적
                combination(j, sum + arr[j][2]);
            }
        }
        if (!flag) {
            max = Math.max(max, sum); // 최대 금액 비교 및 갱신
        }
    }
}