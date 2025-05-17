import java.io.*;
import java.util.*;

class Solution {
    static class Pair {
        int N;
        int rootN;
        Pair(int N, int rootN) {
            this.N = N;
            this.rootN = rootN;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(1000); i++) {
            arr.add(new Pair(i * i, i));
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int count = 0;
            for (Pair p : arr) {
                if (A <= p.N && p.N <= B) {
                    String str1 = Integer.toString(p.N);
                    String str2 = Integer.toString(p.rootN);
                    boolean flag = false;
                    for (int i = 0; i < str1.length() / 2; i++) {
                        if (str1.charAt(i) != str1.charAt(str1.length() - 1 - i)) {
                            flag = true;
                            break;
                        }
                    }
                    for (int i = 0; i < str2.length() / 2; i++) {
                        if (str2.charAt(i) != str2.charAt(str2.length() - 1 - i)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) count++;
                }
            }
            sb.append("#").append(t + 1).append(" ").append(count).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}