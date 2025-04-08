import jdk.jfr.Unsigned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long S = Long.parseLong(br.readLine());

        long count = S;
        int N = 0;
        for (long jys = 1; jys <= S; jys++) {
            if (count >= jys) {
                count -= jys;
                N++;
            }
            else break;
        }
        System.out.println(N);

        br.close();
    }
}