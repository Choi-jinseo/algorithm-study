import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                String left = "";
                String right = "";
                if (arr[i] > 0) {
                    for (int j = 0; j < str.length(); j++) {
                        if (j < arr[i] % str.length()) left += str.charAt(j);
                        else right += str.charAt(j);
                    }
                    str = right + left;
                } else if (arr[i] < 0) {
                    for (int j = 0; j < str.length(); j++) {
                        if (j < str.length() - Math.abs(arr[i]) % str.length()) left += str.charAt(j);
                        else right += str.charAt(j);
                    }
                    str = right + left;
                }
            }
            sb.append(str).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}