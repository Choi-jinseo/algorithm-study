import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A);
        int sum;
        while (true) {
            String s = Integer.toString(A);
            sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += Math.pow(s.charAt(i) - '0', P);
            }
            if (arr.contains(sum)) break;
            arr.add(sum);
            A = sum;
        }
        System.out.println(arr.indexOf(sum));
        br.close();
    }
}
