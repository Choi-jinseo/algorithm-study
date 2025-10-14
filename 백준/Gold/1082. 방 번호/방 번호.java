import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        String[] dp = new String[m+1];	//dp의 인덱스를 m(총 금액)으로 세팅한다.
        String ans = "0";
        Arrays.fill(dp, "-1");	//초기값 -1으로 세팅 (세팅 없을 시 null 그러면 골치가 살짝 아파짐)

        for(int i = 0 ; i < n ; i++)
        {
            if(price[i] > m) continue;

            //일단 초기에 price[i](금액)으로 맞출 수 있는 번호 넣기
            dp[price[i]] = Integer.toString(i);
        }

        for(int i = 0 ; i <= m ; i++)
        {
            if(dp[i] != "-1")	//"-1"은 쓰레기 값으로 무시
            {
                for(int j = 0 ; j < n ; j++)
                {
                    if(i + price[j] <= m) //허용 금액 초과하지 않는 선에서
                    {
                        //만들 수 있는 번호의 조합
                        String newString = dp[i] + Integer.toString(j);

                        BigInteger num1 = new BigInteger(newString);
                        BigInteger num2 = new BigInteger(dp[i + price[j]]);

                        //9가 50개 들어갈 수 있어서 문자열로 선언했지만 비교는 숫자로 해줘야하는...
                        int result = num1.compareTo(num2);

                        if(result > 0)
                        {
                            //만들 수 있는 숫자가 기존 숫자보다 큰 경우 스위칭
                            dp[i + price[j]] = newString;
                        }
                    }
                }
            }
        }

        for(String s : dp)	//다 뒤져보면서 최상의 경우의 수 선택
        {
            BigInteger num1 = new BigInteger(s);
            BigInteger num2 = new BigInteger(ans);

            int result = num1.compareTo(num2);

            if(result > 0)
                ans = s;
        }

        System.out.println(ans);
    }
}
