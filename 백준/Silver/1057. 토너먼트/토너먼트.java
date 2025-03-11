import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        int count = 1;
        while (N > 1) {
            if (isMatching(kim, lim)) {
                System.out.println(count);
                break;
            }
            N = (N+1)/2;
            kim = (kim+1)/2;
            lim = (lim+1)/2;
            count++;
        }
        if (N == 1) {
            System.out.println(-1);
        }
        br.close();
    }

    static boolean isMatching(int x, int y) {
        if (x - y == 1 && y % 2 == 1) { // ex. 1,2 혹은 5,6
            return true;
        } else if (y - x == 1 && x % 2 == 1) {
            return true;
        } else return false;
    }
}