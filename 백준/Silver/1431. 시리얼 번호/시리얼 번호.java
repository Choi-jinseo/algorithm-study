import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        // 짧은 문자
        // 자릿수합이 적은 문자
        // 사전순 (숫자가 더 작음)
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        for (int i = 1; i < N; i++) { // 버블 정렬
            for (int j = 0; j < N - i; j++) {
                if (str[j].length() > str[j+1].length()) {
                    swap(str, j, j + 1);
                }
                else if (str[j].length() == str[j+1].length()) {
                    int cnt1 = 0;
                    int cnt2 = 0;
                    for (int k = 0; k < str[j].length(); k++) {
                        if (str[j].charAt(k) >= '0' && str[j].charAt(k) <= '9') cnt1 = cnt1 + (str[j].charAt(k) - '0');
                        if (str[j+1].charAt(k) >= '0' && str[j+1].charAt(k) <= '9') cnt2 = cnt2 + (str[j+1].charAt(k) - '0');
                    }
                    if (cnt1 > cnt2) {
                        swap(str, j, j + 1);
                    }
                    else if (cnt1 == cnt2) {
                        for (int k = 0; k < str[j].length(); k++) {
                            if (str[j].charAt(k) >= '0' && str[j].charAt(k) <= '9') cnt1 = str[j].charAt(k) - '0';
                            else cnt1 = str[j].charAt(k) - 'A' + 10;
                            if (str[j+1].charAt(k) >= '0' && str[j+1].charAt(k) <= '9') cnt2 = str[j+1].charAt(k) - '0';
                            else cnt2 = str[j+1].charAt(k) - 'A' + 10;
                            if (cnt1 > cnt2) {
                                swap(str, j, j + 1);
                                break;
                            }
                            else if (cnt1 < cnt2) break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(str[i]);
        }

        br.close();
    }
    static void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}