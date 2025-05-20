import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] arr = new char[H][W];
            // 전차 위치
            int x = 0;
            int y = 0;
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
                        x = i;
                        y = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            int[] command = new int[N];
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                command[i] = str.charAt(i);
            }
            for (int i = 0; i < N; i++) {
                if (command[i] == 'U') {
                    if (x - 1 >= 0 && arr[x-1][y] == '.') { // 이동 불가
                        arr[x][y] = '.';
                        x--;
                    }
                    arr[x][y] = '^'; // 전차 방향 바꾸기
                } else if (command[i] == 'D') {
                    if (x + 1 < H && arr[x+1][y] == '.') { // 이동 불가
                        arr[x][y] = '.';
                        x++;
                    }
                    arr[x][y] = 'v'; // 전차 방향 바꾸기
                } else if (command[i] == 'L') {
                    if (y - 1 >= 0 && arr[x][y-1] == '.') { // 이동 불가
                        arr[x][y] = '.';
                        y--;
                    }
                    arr[x][y] = '<'; // 전차 방향 바꾸기
                } else if (command[i] == 'R') {
                    if (y + 1 < W && arr[x][y+1] == '.') { // 이동 불가
                        arr[x][y] = '.';
                        y++;
                    }
                    arr[x][y] = '>'; // 전차 방향 바꾸기
                } else if (command[i] == 'S') {
                    if (arr[x][y] == '^') {
                        for (int j = x-1; j >= 0; j--) {
                            if (arr[j][y] == '#') break;
                            else if (arr[j][y] == '*') {
                                arr[j][y] = '.';
                                break;
                            }
                        }
                    } else if (arr[x][y] == 'v') {
                        for (int j = x+1; j < H; j++) {
                            if (arr[j][y] == '#') break;
                            else if (arr[j][y] == '*') {
                                arr[j][y] = '.';
                                break;
                            }
                        }
                    } else if (arr[x][y] == '<') {
                        for (int j = y-1; j >= 0; j--) {
                            if (arr[x][j] == '#') break;
                            else if (arr[x][j] == '*') {
                                arr[x][j] = '.';
                                break;
                            }
                        }
                    } else if (arr[x][y] == '>') {
                        for (int j = y+1; j < W; j++) {
                            if (arr[x][j] == '#') break;
                            else if (arr[x][j] == '*') {
                                arr[x][j] = '.';
                                break;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
        br.close();
    }
}
