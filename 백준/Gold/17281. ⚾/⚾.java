import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] player;
    static int[] order = new int[9];
    static boolean[] isSelected = new boolean[9];
    static boolean[] lu = new boolean[3]; // 루
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 이닝 수
        player = new int[9][N]; // 9명, 이닝별 결과

        for (int i = 0; i < N; i++) { // 이닝
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) { // 선수
                player[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        order[3] = 0; // 4번 타자는 1번 선수
        isSelected[0] = true;
        // permutation
        dfs(0);

        play();

        System.out.println(max);
    }
    static void dfs(int idx) { // idx 번 타자
        if (idx == 9) { // 순열이 완성되었다면
            // 점수 계산 메서드 호출
            play();
        }
        if (idx == 3) idx++; // 4 번 타자는
        for (int i = 0; i < 9; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            order[idx] = i; // i번 선수는 idx 번 타자가 됨
            dfs(idx+1);
            isSelected[i] = false; // 다음 경우를 위해 리셋
        }
    }
    static void play() {
        int score = 0; // 점수
        int outCnt = 0; // 아웃 카운트
        int in = 0; // 이닝 번호
        int idx = 0; // 현재 선수 번호

        while (in < N) { // N 이닝 까지 반복
            int event = player[order[idx]][in]; // 타자가 벌이는 일
            // 아웃
            if (event == 0) {
                outCnt++; // 아웃 수 +1
                // 이닝 변경 조건
                if (outCnt == 3) { // 3 아웃
                    in++; // 다음 이닝
                    outCnt = 0; // 아웃 카운트 초기화
                    // 루 초기화
                    lu[0] = false;
                    lu[1] = false;
                    lu[2] = false;
                }
            }
            // 안타
            else if (event == 1) { // 안타
                if (lu[2]) { // 3루 -> 홈 (득점)
                    lu[2] = false; // 3루 비우기
                    score++;
                }
                if (lu[1]) { // 2루 -> 3루
                    lu[1] = false;
                    lu[2] = true;
                }
                if (lu[0]) { // 1루 -> 2루
                    lu[0] = false;
                    lu[1] = true;
                }
                lu[0] = true; // 타석 -> 1루
            }
            // 2루타
            else if (event == 2) {
                if (lu[2]) { // 3루 -> 홈 (득점)
                    lu[2] = false;
                    score++;
                }
                if (lu[1]) { // 2루 -> 홈 (득점)
                    lu[1] = false;
                    score++;
                }
                if (lu[0]) { // 1루 -> 3루
                    lu[0] = false;
                    lu[2] = true;
                }
                lu[1] = true; // 타석 -> 2루
            }
            // 3루타
            else if (event == 3) {
                if (lu[2]) { // 3루 -> 홈 (득점)
                    lu[2] = false;
                    score++;
                }
                if (lu[1]) { // 2루 -> 홈 (득점)
                    lu[1] = false;
                    score++;
                }
                if (lu[0]) { // 1루 -> 홈 (득점)
                    lu[0] = false;
                    score++;
                }
                lu[2] = true; // 타석 -> 3루
            }
            // 홈런
            else if (event == 4) {
                if (lu[2]) { // 3루 -> 홈 (득점)
                    lu[2] = false;
                    score++;
                }
                if (lu[1]) { // 2루 -> 홈 (득점)
                    lu[1] = false;
                    score++;
                }
                if (lu[0]) { // 1루 -> 홈 (득점)
                    lu[0] = false;
                    score++;
                }
                score++; // 타석 -> 홈 (득점)
            }
            // 순서는 매번 증가
            idx++;
            if (idx == 9) idx = 0; // 8번 다음은 0번
        }
        max = Math.max(max, score);
    }
}
