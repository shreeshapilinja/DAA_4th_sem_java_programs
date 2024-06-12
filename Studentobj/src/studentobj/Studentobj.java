/*
Create a Java class called Student with the following details as
variables within it. (i) USN (ii) Name (iii) Branch (iv) Phone
Write a Java program to create n Student objects and print the USN,
Name, Branch and Phone of these objects with suitable headings.
*/
package studentobj;
import java.util.Scanner;
class Student
{
    Scanner sc = new Scanner(System.in);
    String usn,name,branch,phone;
    void read()
    {
        usn = sc.next();
        name = sc.next();
        branch = sc.next();
        phone =sc.next();
    }
    void display()
    {
        System.out.println(usn+"\t"+name+"\t"+branch+"\t"+phone);
    }

}

public class Studentobj {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the nos of students: ");
        n = sc.nextInt();
        Student s[] = new Student[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Student();
            System.out.println("Enter the "+i+"th students details");
            s[i].read();
        }
        System.out.println("The details of students\n usn \t name\t branch\tphone");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
    }
    
}
