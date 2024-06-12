package exception;
import java.util.Scanner;
public class Exception {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        System.out.println("Enter the values of a and b");
        a = sc.nextInt();
        b = sc.nextInt();
        try {
            System.out.println("the division value is "+(a/b));
        } catch(ArithmeticException e) {
            System.out.println(e);
        }
    }
    
}
