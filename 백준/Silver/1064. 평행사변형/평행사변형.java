import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xA = Integer.parseInt(st.nextToken());
        int yA = Integer.parseInt(st.nextToken());
        int xB = Integer.parseInt(st.nextToken());
        int yB = Integer.parseInt(st.nextToken());
        int xC = Integer.parseInt(st.nextToken());
        int yC = Integer.parseInt(st.nextToken());

        double AB = distance(xA, yA, xB, yB); // AB 거리
        double AC = distance(xA, yA, xC, yC); // AC 거리
        double BC = distance(xB, yB, xC, yC); // BC 거리

        if ((yA-yB)*(xA-xC) == (yA-yC)*(xA-xB)) {
            System.out.println(-1);
            return;
        }

        double max = Math.max(Math.max(AB + AC, AB + BC), AC + BC);
        double min = Math.min(Math.min(AB + AC, AB + BC), AC + BC);

        System.out.println((max - min) * 2);

        br.close();
    }
    static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}