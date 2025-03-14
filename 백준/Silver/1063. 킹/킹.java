import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] table = new int[10][10];
        for (int i = 0; i < 10; i++) { // 테두리 1로 만들기
            table[i][0] = 1;
            table[i][9] = 1;
            table[0][i] = 1;
            table[9][i] = 1;
        }

        String position = st.nextToken();
        int[] king = {position.charAt(0)-64, position.charAt(1)-48};
        table[position.charAt(0)-64][position.charAt(1)-48] = 1;

        position = st.nextToken();
        int[] stone = {position.charAt(0)-64, position.charAt(1)-48};
        table[position.charAt(0)-64][position.charAt(1)-48] = 1;

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            switch (s) {
                case "R":
                    if (king[0] + 1 == stone[0] && king[1] == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0] + 1][stone[1]] == 0) {
                            table[stone[0] + 1][stone[1]] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[0]++;
                            king[0]++;
                        }
                    }
                    else if (table[king[0] + 1][king[1]] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0] + 1][king[1]] = 1;
                        king[0]++;
                    }
                    break;
                case "L":
                    if (king[0] - 1 == stone[0] && king[1] == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0] - 1][stone[1]] == 0) {
                            table[stone[0] - 1][stone[1]] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[0]--;
                            king[0]--;
                        }
                    }
                    else if (table[king[0] - 1][king[1]] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0] - 1][king[1]] = 1;
                        king[0]--;
                    }
                    break;
                case "B":
                    if (king[0] == stone[0] && king[1] - 1 == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0]][stone[1] - 1] == 0) {
                            table[stone[0]][stone[1] - 1] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[1]--;
                            king[1]--;
                        }
                    }
                    else if (table[king[0]][king[1] - 1] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0]][king[1] - 1] = 1;
                        king[1]--;
                    }
                    break;
                case "T":
                    if (king[0] == stone[0] && king[1] + 1 == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0]][stone[1] + 1] == 0) {
                            table[stone[0]][stone[1] + 1] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[1]++;
                            king[1]++;
                        }
                    }
                    else if (table[king[0]][king[1] + 1] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0]][king[1] + 1] = 1;
                        king[1]++;
                    }
                    break;
                case "RT":
                    if (king[0] + 1 == stone[0] && king[1] + 1 == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0] + 1][stone[1] + 1] == 0) {
                            table[stone[0] + 1][stone[1] + 1] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[0]++;
                            stone[1]++;
                            king[0]++;
                            king[1]++;
                        }
                    }
                    else if (table[king[0] + 1][king[1] + 1] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0] + 1][king[1] + 1] = 1;
                        king[0]++;
                        king[1]++;
                    }
                    break;
                case "LT":
                    if (king[0] - 1 == stone[0] && king[1] + 1 == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0] - 1][stone[1] + 1] == 0) {
                            table[stone[0] - 1][stone[1] + 1] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[0]--;
                            stone[1]++;
                            king[0]--;
                            king[1]++;
                        }
                    }
                    else if (table[king[0] - 1][king[1] + 1] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0] - 1][king[1] + 1] = 1;
                        king[0]--;
                        king[1]++;
                    }
                    break;
                case "RB":
                    if (king[0] + 1 == stone[0] && king[1] - 1 == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0] + 1][stone[1] - 1] == 0) {
                            table[stone[0] + 1][stone[1] - 1] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[0]++;
                            stone[1]--;
                            king[0]++;
                            king[1]--;
                        }
                    }
                    else if (table[king[0] + 1][king[1] - 1] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0] + 1][king[1] - 1] = 1;
                        king[0]++;
                        king[1]--;
                    }
                    break;
                case "LB":
                    if (king[0] - 1 == stone[0] && king[1] - 1 == stone[1]) { // stone이 king의 길에 있을때
                        if (table[stone[0] - 1][stone[1] - 1] == 0) {
                            table[stone[0] - 1][stone[1] - 1] = 1;
                            table[king[0]][king[1]] = 0;
                            stone[0]--;
                            stone[1]--;
                            king[0]--;
                            king[1]--;
                        }
                    }
                    else if (table[king[0] - 1][king[1] - 1] == 0) { // 빈 곳일때
                        table[king[0]][king[1]] = 0;
                        table[king[0] - 1][king[1] - 1] = 1;
                        king[0]--;
                        king[1]--;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.print((char)(king[0] + 64));
        System.out.println((char)(king[1] + 48));
        System.out.print((char)(stone[0] + 64));
        System.out.println((char)(stone[1] + 48));

        br.close();
    }
}