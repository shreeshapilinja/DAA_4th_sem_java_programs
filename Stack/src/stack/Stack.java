/*
Write a Java program to implement the Stack using arrays. Write
Push(), Pop() and Display() methods to demonstrate its working.
*/
package stack;
import java.util.Scanner;
public class Stack {
    static int array[];
    static int n,top=-1;
    static void push(int elem)
    {
        if(top==n-1)
        {
            System.out.println("Stack is full");
        }
        else
        {
            top++;
            array[top]  = elem;
        }
    }
    static void pop()
    {
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("popped element is "+array[top--]);
        }
    }
    static void display()
    {
        if(top==-1){
            System.out.println("Stack is empty");
        }
        else
        {
            for (int i = 0; i <= top; i++) {
                System.out.print(array[i]+"\t");
            }
            System.out.println("<-- top");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of stack");
        n = sc.nextInt();
        array = new int[n];
        System.out.println("1.push\t2pop\t3.display\t4.exit");
        boolean rerun=true;
        while(rerun)
        {
            System.out.println("Enter the operation to be performed");
            int option = sc.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Enter the element to be pushed");
                    int elem = sc.nextInt();
                    push(elem);
                    break;
                case 2:
                    pop();  
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    rerun = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
}
