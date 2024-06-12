/*
Design a super class called Staff with details as StaffId, Name,
Phone, Salary. Extend this class by writing three subclasses namely
Teaching (domain, publications), Technical (skills), and Contract
(period). Write a Java program to read and display at least 3 staff
objects of all three categories
*/
package staff;
import java.util.Scanner;
public class Staff {
    Scanner sc = new Scanner(System.in);
    String staffid,name,phone,salary;
    void read()
    {
        staffid = sc.nextLine();
        name = sc.nextLine();
        phone=sc.nextLine();
        salary=sc.nextLine();
    }
    void display()
    {
        System.out.print(staffid+"\t"+name+"\t"+phone+"\t"+salary+"\t");
    }
    public static void main(String[] args) {
        Teaching tea[] = new Teaching[3];
        for (int i = 0; i < 3; i++) {
            tea[i] = new Teaching();
            System.out.println("Enter the "+(i+1)+"th teaching details as staffid,name,phone,salary,domain,publication");
            tea[i].read();
        }
        
        Technical tec[] = new Technical[3];
        for (int i = 0; i < 3; i++) {
            tec[i] = new Technical();
            System.out.println("Enter the "+(i+1)+"th Technical details as staffid,name,phone,salary,skills");
            tec[i].read();
        }
        
        Contract con[] = new Contract[3];
        for (int i = 0; i < 3; i++) {
            con[i] = new Contract();
            System.out.println("Enter the "+(i+1)+"th Contract details as staffid,name,phone,salary,period");
            con[i].read();
        }
        System.out.println("the teaching staff details are");
        for (int i = 0; i < 3; i++) {
            tea[i].display();
        }
        System.out.println("the technical staff details are");
        for (int i = 0; i < 3; i++) {
            tec[i].display();
        }
        System.out.println("the contract staff details are");
        for (int i = 0; i < 3; i++) {
            con[i].display();
        }
    }
}
class Teaching extends Staff
{
    Scanner sc = new Scanner(System.in);
    String domain,publication;
    void read()
    {
        super.read();
        domain = sc.nextLine();
        publication = sc.nextLine();
    }
    void display()
    {
        super.display();
        System.out.println(domain+"\t"+publication);
    }
}
class Technical extends Staff
{
    Scanner sc = new Scanner(System.in);
    String skills;
    void read()
    {
        super.read();
        skills = sc.nextLine();
    }
    void display()
    {
        super.display();
        System.out.println(skills);
    }
}
class Contract extends Staff
{
    Scanner sc = new Scanner(System.in);
   String period; 
    void read()
    {
        super.read();
        period = sc.nextLine();
    }
    void display()
    {
        super.display();
        System.out.println(period);
    }
}
