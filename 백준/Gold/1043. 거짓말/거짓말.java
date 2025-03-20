import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        st = new StringTokenizer(br.readLine());
        int tSize = Integer.parseInt(st.nextToken());
        ArrayList<Integer> tList = new ArrayList<>();
        ArrayList<Integer>[] parties = new ArrayList[M]; // 파티 정보
        int[][] relation = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
        }

        for (int i = 0; i < tSize; i++) {
            tList.add(Integer.parseInt(st.nextToken())); // 진실을 아는 사람 리스트
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pSize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pSize; j++) {
                int person = Integer.parseInt(st.nextToken());
                parties[i].add(person); // 파티 레코드
            }
        }
        for (int i = 0; i < M; i++) { // 파티 레코드 탐색하면서 tList 완성하기
            for (int j = 0; j < parties[i].size()-1; j++) {
                for (int k = j+1; k < parties[i].size(); k++) {
                    relation[parties[i].get(j)][parties[i].get(k)] = 1;
                    relation[parties[i].get(k)][parties[i].get(j)] = 1;
                }
            }
        }
        Set<Integer> check = new HashSet<>();
        while (!tList.isEmpty()) {
            if (!check.contains(tList.get(0))) {
                check.add(tList.get(0));
                for (int i = 0; i < N+1; i++) {
                    if (relation[tList.get(0)][i] == 1) {
                        if (!check.contains(i) && !tList.contains(i)) tList.add(i);
                    }
                }
                tList.remove(0);
            }
        }
        int count = M;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < parties[i].size(); j++) {
                if (check.contains(parties[i].get(j))) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}