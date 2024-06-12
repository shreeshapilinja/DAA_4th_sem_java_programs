import java.util.Scanner;
class Stack
{
    private int top;
    private int[] item;
    Stack(int size)
    {
        top = -1;
        item = new int[size];
    }
    public void push(int data){
        if (top==item.length-1) 
        {
            System.out.println("stack overflow");
        } 
        else 
        {
            item[++top]=data;
        }
    }
    public int pop()
    {
        if (top<0) 
        {
            System.out.println("Stack underflow");
            return 0;
        } 
        else 
        {
            System.out.println("poped item is: "+item[top]);
            return item[top--];
        }
    }
    public void display()
    {
        if (top==-1) 
        {
            System.out.println("stack is empty");
        } 
        else 
        {
            System.out.print("stack items: ");
            for (int i = 0; i <=top; i++) 
            {
                System.out.print(item[i]+" ");
            }
            System.out.println("<-- top element");
        }
    }
}
public class Stackdemo {

    public static void main(String[] args) {
        Stack stk = new Stack(3);
        boolean rerun = true;
        int choice,num;
        Scanner sc = new Scanner(System.in);
        do {            
            System.out.println("\nMenu 1)push  2)pop  3)display  4)exit");
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the item to be pushed");
                    num = sc.nextInt();
                    stk.push(num);
                    break;
                case 2:
                    stk.pop();
                    break;
                case 3:
                    stk.display();
                    break;
                case 4:
                    rerun = false;
                    break;
                default:
                    System.out.println("invalid choice");
            }
        } while (rerun==true);
    }
}
