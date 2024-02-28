import java.util.*;
public class oddSum {
    public static int sumOfOdd(int n){
        int sum = 0;
        for(int i = 1; i <= n; i = i+2){
            sum = sum + i;
        }
        return sum; 
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oddSum = sumOfOdd(n);
        System.out.println(oddSum);
    }

}
