import java.util.Scanner;
class Student {
    private String USN;
    private String Name;
    private String Branch;
    private String Phone;
    public void read()
    {
        Scanner sc = new Scanner(System.in);
        USN = sc.nextLine();
        Name = sc.nextLine();
        Branch = sc.nextLine();
        Phone = sc.nextLine();
    }
    public void display()
    {
        System.out.println(USN+'\t'+Name+'\t'+Branch+'\t'+Phone);
    }
}
public class Studentinfo {

    public static void main(String[] args) {
        System.out.println("Enter the nos of students: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Student st[] = new Student[100];
        for(int i=0;i<st.length;i++)
        {
            st[i]=new Student();
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the USN Name Branch Phone");
            st[i].read();
        }
        System.out.println("USN\t\tName\t\tBranch\tPhone");
        for(int i=0;i<n;i++)
        {
            st[i].display();
        }
    }
    
}
