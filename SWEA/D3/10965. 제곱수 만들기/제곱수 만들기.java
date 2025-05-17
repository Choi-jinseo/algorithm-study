import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isNotPrimes = new boolean[10000001];
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 10000000; i++) {
            if (!isNotPrimes[i]) {
                primes.add(i);
                for (int j = i+i; j <= 10000000; j+=i) {
                    isNotPrimes[j] = true;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int A = Integer.parseInt(br.readLine());
            int answer = 1;
            for (int prime : primes) {
                if (prime > Math.sqrt(A)) break;
                boolean flag = false;
                while (A % prime == 0) {
                    A /= prime;
                    flag = !flag;
                }
                if (flag) answer *= prime;
            }
            if (A > 1) answer *= A;
            sb.append("#").append(t+1).append(" ").append(answer).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}