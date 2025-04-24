import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visitedA;
    static boolean[][] visitedB;
    static String[] strA;
    static String[] strB;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        strA = new String[N];
        strB = new String[N];
        visitedA = new boolean[N][N];
        visitedB = new boolean[N][N];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < N; i++) {
            strA[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            strB[i] = "";
            for (int j = 0; j < N; j++) {
                if (strA[i].charAt(j) == 'G') strB[i] += 'R';
                else strB[i] += strA[i].charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedA[i][j]) {
                    dfsA(i, j, strA[i].charAt(j));
                    countA++;
                }
                if (!visitedB[i][j]) {
                    dfsB(i, j, strB[i].charAt(j));
                    countB++;
                }
            }
        }
        System.out.println(countA + " " + countB);
        br.close();
    }
    static void dfsA (int i, int j, char color) {
        visitedA[i][j] = true;
        if (i-1>=0&&!visitedA[i-1][j]&&strA[i-1].charAt(j) == color) dfsA(i-1, j,color);
        if (i+1<N&&!visitedA[i+1][j]&&strA[i+1].charAt(j) == color) dfsA(i+1, j,color);
        if (j-1>=0&&!visitedA[i][j-1]&&strA[i].charAt(j-1) == color) dfsA(i, j-1,color);
        if (j+1<N&&!visitedA[i][j+1]&&strA[i].charAt(j+1) == color) dfsA(i, j+1,color);
    }
    static void dfsB (int i, int j, char color) {
        visitedB[i][j] = true;
        if (i-1>=0&&!visitedB[i-1][j]&&strB[i-1].charAt(j) == color) dfsB(i-1, j,color);
        if (i+1<N&&!visitedB[i+1][j]&&strB[i+1].charAt(j) == color) dfsB(i+1, j,color);
        if (j-1>=0&&!visitedB[i][j-1]&&strB[i].charAt(j-1) == color) dfsB(i, j-1,color);
        if (j+1<N&&!visitedB[i][j+1]&&strB[i].charAt(j+1) == color) dfsB(i, j+1,color);
    }
}