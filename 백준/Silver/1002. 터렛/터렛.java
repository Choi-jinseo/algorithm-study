import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            double r3 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

//            case1 = 두점;
//            r1 + r2 > r3 > |r1 - r2|
//            case2 = 떨어진 한점; /
//            r1 + r2 == r3
//            case3 = 안에서 접하는 한점; /
//            r3 = |r1 - r2|
//            case4 = 떨어짐; /
//            r1 + r2 < r3
//            case5 = 안에 있는데 떨어짐;
//            r3 < |r1 - r2|

            if (r1 + r2 == r3) { // 외접
                System.out.println(1);
            }
            else if (r1 + r2 < r3) { // 밖에서 떨어짐
                System.out.println(0);
            }
            else if (r3 == Math.abs(r1 - r2)) { // 내접
                if (x1 == x2 && y1 == y2 && r1 == r2) {
                    System.out.println(-1);
                }
                else System.out.println(1);
            }
            else if (r3 < Math.abs(r1 - r2)) { // 안-떨
                System.out.println(0);
            }
            else if (r1 + r2 > r3 && r3 > Math.abs(r1 - r2)) { // 두점
                System.out.println(2);
            }
            else System.out.println(-1);
        }

        br.close();
    }
}