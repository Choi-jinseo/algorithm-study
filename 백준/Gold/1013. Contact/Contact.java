import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // (100+1+ | 01)+
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            boolean check01 = false;
            boolean check100And1 = false;
            boolean isPattern = true;
            for (int i = 0; i < str.length();) {
                if (i < str.length() - 2 && str.charAt(i) == '1' && str.charAt(i+1) == '0' && str.charAt(i+2) == '0') { // 100+1+
                    i = i + 3;
                    boolean check1 = false;
                    int count = 0;
                    for (int j = i; j < str.length(); j++) {
                        if (str.charAt(j) == '1') {
                            i = j;
                            check100And1 = true;
                            check1 = true;
                            break;
                        }
                    }
                    if (check1 == false) {
                        isPattern = false;
                        break;
                    }
                    else while (i < str.length() && str.charAt(i) == '1') { // 111...
                        i++;
                        count++;
                    }
                    if (i < str.length() - 1 && count >= 2 && str.charAt(i) == '0' && str.charAt(i+1) == '0') { // 1001100...1
                        i--; // 1001 에서 끝. 100...1 을 다음 토큰으로 받아야 함으로 i--
                    }
                }
                else if (i < str.length() - 1 && str.charAt(i) == '0' && str.charAt(i+1) == '1') { // 01
                    i = i + 2;
                    check01 = true;
                }
                else {
                    isPattern = false;
                    break;
                }
            }
            if (isPattern == true && (check01 || check100And1)) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();
    }
}