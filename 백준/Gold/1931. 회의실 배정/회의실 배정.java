import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new int[] {a, b});
        }
        arr.sort((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        int cnt = 1; // 최대로 가능한 회의 수
        int curFinish = arr.get(0)[1]; // 현재 회의 종료 시간
        for (int i = 1; i < N; i++) {
            int nextStart = arr.get(i)[0];
            int nextFinish = arr.get(i)[1];
            if (nextStart >= curFinish) { // 갱신
                cnt++;
                curFinish = nextFinish;
            }
        }
        System.out.println(cnt);

        br.close();
    }
}
