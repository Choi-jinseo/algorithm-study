import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> hs = new HashSet<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            String temp = "";
            for (int j = i; j < str.length(); j++) {
                temp += str.charAt(j);
                hs.add(temp);
            }
        }
        System.out.println(hs.size());
        br.close();
    }

}