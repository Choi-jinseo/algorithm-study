import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int five = N / 5;
        int answer = five + five / 5 + five / 25;
//        5 10 15 20 25(5) ... 125(25) ... 500 ... 625(125)

        System.out.println(answer);
        br.close();
    }
}