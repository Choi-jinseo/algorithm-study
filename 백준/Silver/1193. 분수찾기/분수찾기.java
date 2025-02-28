import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine()); // 정수 입력받기
        br.close();

        int line = 1;
        
        while (true) {
            if (x <= sum(line)) {
                break;
            }
            line++;
        }

        int upper, under;
        if (line % 2 == 0) { // 짝수
            under = sum(line) - x + 1;
            upper = line - (sum(line) - x);
        } else { // 홀수
            upper = sum(line) - x + 1;
            under = line - (sum(line) - x);
        }

        System.out.println(upper + "/" + under);
    }

    // 주어진 line에 대해 1부터 line까지의 합을 구하는 함수
    static int sum(int n) {
        return n * (n + 1) / 2;
    }
}