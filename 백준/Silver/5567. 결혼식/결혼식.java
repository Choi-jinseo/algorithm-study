import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N]; // 친구 관계 테이블
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = true;
            arr[b][a] = true;
        }
        boolean[] partyPeople = new boolean[N]; // 결혼식 참여자
        for (int i = 0; i < N; i++) {
            if(arr[0][i]) {
                partyPeople[i] = true; // 상근이의 친구 체킹
                for (int j = 0; j < N; j++) {
                    if (arr[i][j]) partyPeople[j] = true; // 그 친구의 친구 체킹
                }
            }
        }
        // 참여자 수 구하기
        int cnt = 0;
        partyPeople[0] = false; // 상근이는 제외
        for (int i = 0; i < N; i++) {
            if (partyPeople[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
