import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // T : testCase 개수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // (x1, y1) : 출발점
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            // (x2, y2) : 도착점
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // n : 원 개수
            int n = Integer.parseInt(br.readLine());
            // count : 진입/이탈 횟수
            int count = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                // 점이 원 안에 있으면
                if ((cx-x1)*(cx-x1) + (cy-y1)*(cy-y1) < r*r
                        || (cx-x2)*(cx-x2) + (cy-y2)*(cy-y2) < r*r) {
                    // 두 점이 원 안에 있다면
                    if ((cx-x1)*(cx-x1) + (cy-y1)*(cy-y1) < r*r
                            && (cx-x2)*(cx-x2) + (cy-y2)*(cy-y2) < r*r) {
                        continue;
                    }
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}