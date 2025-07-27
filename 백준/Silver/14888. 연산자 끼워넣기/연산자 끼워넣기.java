/*
아이디어: 큐를 이용한 구현
    가변 길이의 뱀이 2차원 배열에서 이동하는 것을 구현하기 위한
    뱀 몸의 위치(여러 좌표)를 큐에 저장하는 방법으로 머리는 add 하고 꼬리는 poll 을 반복
    사과, 벽, 뱀의 몸과 닿는 경우에 따른 처리를 구현.

메모리: 14456 KB
시간: 104 ms
난이도: ★★★☆☆
    아이디어 보다, 경우에 따른 처리와 구현에 난이도가 있음
 */

import java.util.*;
import java.io.*;
class Main {
    static int N;
    static int[] arr;
    static int[] oper;
    static int min;
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        oper = new int[4]; // + - * %
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        oper[0] = Integer.parseInt(st.nextToken()); // +
        oper[1] = Integer.parseInt(st.nextToken()); // -
        oper[2] = Integer.parseInt(st.nextToken()); // *
        oper[3] = Integer.parseInt(st.nextToken()); // %
        dfs(arr[0], 0);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }
    static void dfs(int left, int idx) {
        if (idx == N-1) { // 재귀 종료 및 최댓값, 최솟값 갱신
            min = Math.min(min, left);
            max = Math.max(max, left);
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (oper[i] > 0) {
                    oper[i]--; // 해당 연산자 1개 소비
                    if (i==0) {
                        dfs(left+arr[idx+1], idx+1);
                    }
                    else if (i==1) {
                        dfs(left-arr[idx+1], idx+1);
                    }
                    else if (i==2) {
                        dfs(left*arr[idx+1], idx+1);
                    }
                    else {
                        dfs(left/arr[idx+1], idx+1);
                    }
                    oper[i]++; // 다른 연산자를 선택하는 재귀를 위해 복구
                }
            }
        }
    }
}