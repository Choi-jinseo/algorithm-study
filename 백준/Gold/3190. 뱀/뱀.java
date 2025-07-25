import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력1. 보드, 뱀, 사과
        int N = Integer.parseInt(br.readLine()); // 보드 크기
        int K = Integer.parseInt(br.readLine()); // 사과 개수
        int[][] map = new int[N][N]; // N*N 보드
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1; // 나는 0부터 사용할 것이기 때문
            int y = Integer.parseInt(st.nextToken())-1; // ''
            map[x][y] = 4; // 보드의 4과.. 위치 표시
        }
        // 뱀의 위치를 담은 큐 (머리부터 꼬리까지)
        Queue<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0,0}); // 시작 위치 (머리위치==꼬리위치)
        map[0][0] = 1; // 보드에 뱀은 1로 표시
        int[][] dTable = {{0,1},{1,0},{0,-1},{-1,0}}; // 이동 방향 (시계방향 순으로 정의)
        int dIndex = 0; // 현재 방향을 알기위한 인덱스
        int[] d = dTable[dIndex]; // 뱀이 현재 바라보는 방향
        int x = 0; // 뱀의 위치 (x 좌표)
        int y = 0; // 뱀의 위치 (y 좌표)
        int now = 0; // 현재 시간
        boolean flag = false; // 게임 종료 여부

        // 입력2. 이동 명령(시간, 방향)
        int L = Integer.parseInt(br.readLine()); // 이동 명령 수
        int X = 0; // 이동이 끝나는 시간
        int C = 0; // 이동 방향
        for (int i = 0; i < L+1; i++) {
            if (i < L) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                C = st.nextToken().charAt(0);
            }
            else { // 마지막 입력 방향으로 끝까지 수행하는 경우
                X = Integer.MAX_VALUE;
                C = '-'; // 뱡향(C)은 안바뀌도록 설정
            }
            if (flag) continue; // 부딪혔다면 더이상 입력에 대한 로직을 수행할 필요가 없음

            while (now < X) { // X 시간까지 직진
                now++;
                x = x+d[0]; // 이동할 x좌표
                y = y+d[1]; // 이동할 y좌표
                // 이동 가능 여부 확인
                // 1. 보드 범위를 벗어나는지 확인
                if (x < 0 || x >= N || y < 0 || y >= N) {
                    flag = true;
                    break;
                }
                // 2. 몸통에 부딪히는지 확인
                if (map[x][y] == 1) { // 1 은 뱀 이라는 뜻
                    flag = true;
                    break;
                }
                // 이동 가능

                // 이동할 위치가 사과 -> 꼬리는 그대로
                // 사과가 아니면 꼬리 제거
                if (map[x][y] != 4) {
                    int[] tail = snake.poll(); // 뱀 큐에서 꼬리 제거 // 물론, 다음 head가 꼬리가 됩니다.
                    map[tail[0]][tail[1]] = 0; // 보드에서 꼬리 지워주기
                }
                // 이동할 위치에 머리 추가하기
                snake.add(new int[]{x, y}); // 새로운 머리를 뱀 큐에 삽입
                map[x][y] = 1; // 보드에 뱀 표시
            }
            // 방향 갱신
            if (C == 'D') d = dTable[++dIndex % 4]; // 시계방향 90도
            else if (C == 'L') { // 반시계방향 90도
                if (dIndex == 0) {
                    dIndex = 3;
                    d = dTable[dIndex];
                }
                else d = dTable[--dIndex % 4];
            }
            // C == '-' 일때는 방향 안바뀜
        }


        // 정답 출력
        System.out.println(now);
        br.close();
    }
}