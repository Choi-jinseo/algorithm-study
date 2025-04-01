import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        ArrayList<Character> one = new ArrayList<>();
        ArrayList<Character> two = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) { // 현위치
            one.add(str.charAt(i));
            for (int j = 0; j < one.size() - 1; j++) { // 탐색
                if (!one.isEmpty() && str.charAt(i) == one.get(j)) { // ABAC 에서 두번째 A
                    one.remove(one.size() - 1);
                    one.remove(j);
                    two.add(str.charAt(i));
                    break;
                }
            }
        }
        if (one.size() > 1 || str.length() % 2 != one.size() % 2) System.out.println("I'm Sorry Hansoo");
        else {
            char[] crr = new char[str.length()];
            for (int i = 0; i < two.size(); i++) {
                crr[i] = two.get(i);
            }
            for (int i = 1; i < two.size(); i++) {
                for (int j = 0; j < two.size() - i; j++) {
                    if (crr[j] > crr[j+1]) {
                        char temp = crr[j];
                        crr[j] = crr[j+1];
                        crr[j+1] = temp;
                    }
                }
            }
            if (!one.isEmpty()) {
                crr[two.size()] = one.get(0);
                for (int i = two.size() + 1; i < str.length(); i++) {
                    crr[i] = crr[2 * two.size() - i];
                }
            }
            else {
                for (int i = two.size(); i < str.length(); i++) {
                    crr[i] = crr[2 * two.size() - i - 1];
                }
            }
            for (int i = 0; i < crr.length; i++) {
                sb.append(crr[i]);
            }
            System.out.println(sb);
        }
        br.close();
    }
}