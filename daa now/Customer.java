import java.util.Scanner;
import java.util.StringTokenizer;
public class Customer {
    private String name;
    private String dob;
    public void read(){
        System.out.println("Enter the customer name: ");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("Enter the customer dob(dd/mm/yyyy");
        dob = sc.next();
        String datePattern = "\\d{2}/\\d{2}/\\d{4}";
        while(!(dob.matches(datePattern))){
            System.out.println("Please enter the date in  dd/mm/yyyy format");
            dob = sc.next();
        }
    }
    public void display(){
        StringTokenizer st = new StringTokenizer(dob,"/");
        String[] seq = new String[10];
        int i;
        System.out.print("Customer name & DOB is "+name);
        for(i=0;i<3;i++){
            System.out.print(", "+st.nextToken());
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.read();
        c1.display();
    }
    
}
