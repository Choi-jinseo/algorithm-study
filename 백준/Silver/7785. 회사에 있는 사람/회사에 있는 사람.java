import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, String> hashMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            String value = st.nextToken();
            if (value.equals("leave")) hashMap.remove(key);
            else hashMap.put(key, value);
        }
        String[] str = new String[hashMap.size()];
        int i = 0;
        for (String key : hashMap.keySet()) {
            str[i++] = key;
        }
        Arrays.sort(str); // 사전순
        for (int j = hashMap.size()-1; j >= 0; j--) {
            System.out.println(str[j]);
        }

        br.close();
    }
}