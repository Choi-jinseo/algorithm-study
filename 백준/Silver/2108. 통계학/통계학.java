import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans1; // 산술 평균
        int ans2; // 중앙값
        int ans3 = 0; // 최빈값
        int ans4; // 범위

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // ans1 (산술 평균)
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        boolean isMinus = false;
        if (sum < 0) {
            isMinus = true;
            sum *= -1;
        }
        int temp = sum / N;
        ans1 = temp;
        if(sum - temp * N >= (temp+1) * N - sum) { // 큰거에 가까우면
            ans1 = temp+1;
        }
        if (isMinus) ans1 *= -1;

        // ans2 (중앙값)
        Arrays.sort(arr);
        ans2 = arr[N/2];

        // ans3 (최빈값)
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(arr[i])) hm.put(arr[i], hm.get(arr[i])+1);
            else hm.put(arr[i], 1);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > max) max = val;
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val == max) {
                cnt++;
                ans3 = key;
                if (cnt == 2) break;
            }
        }

        // ans4 (범위)
        ans4 = arr[N-1] - arr[0];

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);

        br.close();
    }
}
