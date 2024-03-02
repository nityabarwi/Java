import java.util.*;

public class gcd {
    public static int findGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter greater number: ");
        int num1 = sc.nextInt();

        System.out.println("Enter smaller number: ");
        int num2 = sc.nextInt();

        int result = findGCD(num1, num2);
        System.out.println("GCD OF " + num1+ " and " + num2+ " is: ");
        System.out.println(result);
    }
    
}
