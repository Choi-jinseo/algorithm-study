import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int tc = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int answer = func(N, M, N);
            System.out.println("#" + tc + " " + answer);
        }
        sc.close();
    }
    static int func(int N, int M, int ans) {
        if (M == 1) return ans;
        else {
            return func(N, M - 1, ans * N);
        }
    }
}
