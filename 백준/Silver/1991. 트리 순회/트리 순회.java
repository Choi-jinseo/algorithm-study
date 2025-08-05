/*
아이디어:
    우선 트리구조를 만든 후
    전위 : dfs 호출 순서로 구현
    중위 : dfs 반환 순서로 구현하되, left child 가 없거나 left child 호출이 끝났다면 parent 를 먼저 출력한 후 right child 를 호출한다.
    후위 : dfs 반환 순서로 구현
메모리: 17776 KB
시간: 156 ms
난이도: ★★☆☆☆
 */

import java.util.*;
import java.io.*;
class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // N 개의 노드는 각각 left child, right child 를 갖는다.
        // 0 : left child, 1 : right child
        arr = new int[N][2];

        // 트리 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ME = st.nextToken().charAt(0) - 'A'; // 본인
            int L = st.nextToken().charAt(0) - 'A'; // 왼쪽 자식
            int R = st.nextToken().charAt(0) - 'A'; // 오른쪽 자식
            arr[ME][0] = L;
            arr[ME][1] = R;
        }
        // 루트노드 부터 호출
        dfs1(0); // 전위 순회
        sb.append('\n');
        dfs2(0); // 중위 순회
        sb.append('\n');
        dfs3(0); // 후위 순회
        System.out.println(sb);
    }
    // 전위 순회
    static void dfs1(int ME) {
        sb.append((char)(ME+'A'));
        int left = arr[ME][0];
        int right = arr[ME][1];
        if (left != '.'-'A') dfs1(left); // 왼쪽 자식
        if (right != '.'-'A') dfs1(right); // 왼쪽 자식
    }
    // 중위 순회
    static void dfs2(int ME) {
        int left = arr[ME][0];
        int right = arr[ME][1];
        if (left != '.'-'A') dfs2(left); // 왼쪽 자식
        sb.append((char)(ME+'A'));
        if (right != '.'-'A') dfs2(right); // 왼쪽 자식
    }
    // 후위 순회
    static void dfs3(int ME) {
        int left = arr[ME][0];
        int right = arr[ME][1];
        if (left != '.'-'A') dfs3(left); // 왼쪽 자식
        if (right != '.'-'A') dfs3(right); // 왼쪽 자식
        sb.append((char)(ME+'A'));
    }
}
