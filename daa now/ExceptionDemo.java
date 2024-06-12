import java.util.Scanner;
public class ExceptionDemo {

    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter 2 integer numbers a and b");
            a = sc.nextInt();
            b = sc.nextInt();
            c = a/b;
            System.out.println("No exception");
            System.out.println("Value of c is "+c);
        }catch(ArithmeticException e){
            System.out.println(e);
        }
    }
    
}
