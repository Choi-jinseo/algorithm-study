import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];
        boolean[][] copy = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) != '0';
                copy[i][j] = arr[i][j];
            }
        }
        int K = Integer.parseInt(br.readLine());

        int[] switchCount = new int[N]; // 해당 행을 1로 만드는데 필요한 switch 횟수
        int[] oneLowCount = new int[N]; // 해당 행을 1로 만들었을때 모든 1인 행의 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!arr[i][j]) {
                    switchCount[i]++;
                    for (int k = 0; k < N; k++) {
                        copy[k][j] = !copy[k][j]; // j - switch
                    }
                }
            }
            // check oneLowCount
            for (int j = 0; j < N; j++) { // j행
                boolean isOneRow = true;
                for (int k = 0; k < M; k++) { // k열
                    if (!copy[j][k]) {
                        isOneRow = false;
                        break;
                    }
                }
                if (isOneRow) oneLowCount[i]++;
            }
            // init copy
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    copy[j][k] = arr[j][k];
                }
            }
        }
        // 필터링
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (switchCount[i] <= K && switchCount[i] % 2 == K % 2) answer.add(oneLowCount[i]);
        }
        int max = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (max < answer.get(i)) max = answer.get(i);
        }
        System.out.println(max);

        br.close();
    }
}