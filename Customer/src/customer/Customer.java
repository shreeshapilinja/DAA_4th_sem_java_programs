/*
Write a Java class called Customer to store their name and
date_of_birth. The date_of_birth format should be dd/mm/yyyy.
Write methods to read customer data as <name, dd/mm/yyyy> and
display as <name, dd, mm, yyyy> using StringTokenizer class
considering the delimiter character as "/".
*/
package customer;
import java.util.StringTokenizer;
import java.util.Scanner;
public class Customer {
    static String name,dob;
    static void read()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name");
        name = sc.next();
        System.out.println("Enter the dob");
        dob  = sc.next();
        String dobpattern = "\\d{2}/\\d{2}/\\d{4}";
        while(!(dob.matches(dobpattern)))
        {
            System.out.println("Enter the dob in format dd/mm/yyyy");
            dob  = sc.nextLine();
        }
    }
    static void display()
    {
        StringTokenizer st = new StringTokenizer(dob,"/");
        System.out.print(name);
        for (int i = 0; i < 3; i++) {
            System.out.print(" , "+st.nextToken());
        }
    }
    public static void main(String[] args) {
        read();
        display();
    }
    
}
