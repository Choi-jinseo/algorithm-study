import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        int change = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i-1)) change++;
        }
        System.out.println((change + 1) / 2);

        br.close();
    }
}