import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] str = new String[8];
            HashSet<Integer> hs1 = new HashSet<>();
            HashSet<Integer> hs2 = new HashSet<>();
            for (int i = 0; i < 8; i++) {
                str[i] = br.readLine();
            }
            int count = 0;
            boolean flag = false;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (str[i].charAt(j) == 'O') {
                        count++;
                        if (hs1.contains(i) || hs2.contains(j)) {
                            flag = true;
                            break;
                        }
                        else {
                            hs1.add(i);
                            hs2.add(j);
                        }
                    }
                }
            }
            sb.append("#").append(t+1).append(" ");
            if (count != 8 || flag) sb.append("no");
            else sb.append("yes");
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}