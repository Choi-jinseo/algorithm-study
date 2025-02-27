import java.util.*;
import java.lang.*;
import java.io.*;

// 막대는 반으로 잘려나간다 : 막대 길이는 64,32,16,8,4,2,1 로 한정된다.
// 반으로 자른 막대 중 하나는 버린다 : 서로 다른 길이의 막대는 하나만 존재할 수 있다.
// 막대의 덧셈은 이진수의 덧셈이다 : 큰 수인 64부터 비교,덧셈을 하는 그리디 알고리즘이 최적해를 보장한다.

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int[] arr = {64,32,16,8,4,2,1};
        int sum = 0;
        int num = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= x) {
                sum += arr[i];
                num++;
            }
        }
        System.out.println(num);
    }
}