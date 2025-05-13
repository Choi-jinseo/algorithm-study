import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String strS = st.nextToken();
            String strT = st.nextToken();
            sb.append("#").append(t+1).append(" ");
            if (strS.length() == strT.length()) {
                if (strS.equals(strT)) sb.append("yes");
                else sb.append("no");
            }
            else {
                if (strS.length() < strT.length()) { // strS > strT 변환
                    String temp = strS;
                    strS = strT;
                    strT = temp;
                }
                String iterS = ""; // 반복되는 부분 문자열
                for (int i = 0; iterS.length() < strS.length(); i++) {
                    iterS += strS.charAt(i);
                    String temp = iterS;
                    while (temp.length() < strS.length()) {
                        temp += iterS;
                    }
                    if (temp.equals(strS)) break;
                }
                String iterT = ""; // 반복되는 부분 문자열
                for (int i = 0; iterT.length() < strT.length(); i++) {
                    iterT += strT.charAt(i);
                    String temp = iterT;
                    while (temp.length() < strT.length()) {
                        temp += iterT;
                    }
                    if (temp.equals(strT)) break;
                }
                if (iterS.equals(iterT)) sb.append("yes");
                else sb.append("no");
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}