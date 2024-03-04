import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms in series: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci series is:");
        int firstTerm = 0;
        int secondTerm = 1;
        for(int i=1; i <= n; i++){
            System.out.print(firstTerm + " ");
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
            sc.close();
        }

    }
    
}
