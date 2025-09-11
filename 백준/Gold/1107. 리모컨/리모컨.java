import java.io.*;
import java.util.*;

public class Main {
    static String strN;
    static int numN;
    static ArrayList<Integer> possibleNumbers;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strN = br.readLine(); // 이동할 채널
        numN = Integer.parseInt(strN);
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼 수

        possibleNumbers = new ArrayList<>();
        boolean[] isPossible = new boolean[10];
        for (int i = 0; i < 10; i++) isPossible[i] = true;
        answer = Math.abs(numN - 100); // 숫자 안썼을때 정답

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken()); // 안되는 버튼
                isPossible[num] = false; // 안되는 숫자 체킹
            }
        }
        for (int i = 0; i <= 9; i++) {
            if (isPossible[i]) possibleNumbers.add(i);
        }
        if (possibleNumbers.size() == 0) { // 아무것도 사용할 수 없는 경우
            System.out.println(answer);
        } else if (possibleNumbers.size() == 1 && possibleNumbers.get(0) == 0) { // 남은게 0 하나뿐인 경우
            answer = Math.min(answer, numN + 1);
            System.out.println(answer);
        } else { // 0 이외의 사용할 숫자가 있는 경우
            // (1)
            int min = 0;
            for (int i = 1; i <= 9; i++) {
                if (isPossible[i]) {
                    min = i;
                    break;
                }
            }
            int[] longer = new int[strN.length()+1];
            longer[0] = min;
            for (int i = 1; i < longer.length; i++) {
                longer[i] = isPossible[0] ? 0 : min;
            }
            answer = Math.min(answer, Math.abs(makeNum(longer)-numN) + longer.length);
            // (2)
            if (strN.length() > 1) {
                int max = 9;
                for (int i = 9; i >= 1; i--) {
                    if (isPossible[i]) {
                        max = i;
                        break;
                    }
                }
                int[] shorter = new int[strN.length()-1];
                shorter[0] = max;
                for (int i = 1; i < shorter.length; i++) {
                    shorter[i] = max;
                }
                answer = Math.min(answer, Math.abs(makeNum(shorter)-numN) + shorter.length);
            }
            // (3)
            int[] select = new int[strN.length()];
            for (int num : possibleNumbers) {
                select[0] = num;
                dfs(1, select);
            }
            System.out.println(answer);
        }

        br.close();
    }
    static int makeNum(int[] nrr) {
        int num = 0;
        for (int i = 0; i < nrr.length; i++) {
            num *= 10;
            num += nrr[i];
        }
        return num;
    }
    static void dfs(int size, int[] select) {
        if (size == strN.length()) answer = Math.min(answer, Math.abs(makeNum(select)-numN) + strN.length());
        else {
            for (int i : possibleNumbers) {
                select[size] = i;
                dfs(size+1, select);
            }
        }
    }
}