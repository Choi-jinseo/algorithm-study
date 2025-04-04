import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int size = 0;
        for (int i = 0; i < str.length() - 1; i++) { // 왼쪽 끝
            for (int j = i + 1; j < str.length(); j += 2) { // 오른쪽 끝
                int cnt1 = 0;
                int cnt2 = 0;
                for (int k = i; k <= (i + j) / 2; k++) {
                    cnt1 += str.charAt(k);
                    cnt2 += str.charAt(j + i - k);
                }
                if (cnt1 == cnt2 && size < j - i + 1) size = j - i + 1;
            }
        }
        System.out.println(size);
        br.close();
    }
}