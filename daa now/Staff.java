import java.util.Scanner;
public class Staff {
    private String staffid;
    private String name;
    private String phone;
    private double salary;
    
    void read(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the staffid,name,phone,salary");
        staffid = sc.nextLine();
        name = sc.nextLine();
        phone = sc.nextLine();
        salary = sc.nextDouble();
    }
    void display(){
        System.out.print("\nstaffid: "+staffid+"\tname: "+name+"\tphone: "+phone+"\tsalary: "+salary+"\t");
    }
    public static void main(String[] args) {
        Teaching tch1 = new Teaching();
        Teaching tch2 = new Teaching();
        Teaching tch3 = new Teaching();
        System.out.println("Enter the details of teaching staff");
        tch1.read();
        tch2.read();
        tch3.read();
        
        Technical tec1 = new Technical();
        Technical tec2 = new Technical();
        Technical tec3 = new Technical();
        System.out.println("Enter the details of technical staff");
        tec1.read();
        tec2.read();
        tec3.read();
        
        Contract con1 = new Contract();
        Contract con2 = new Contract();
        Contract con3 = new Contract();
        System.out.println("Enter the details of contract staff");
        con1.read();
        con2.read();
        con3.read();
        
        System.out.println("\nThe details of teaching staff are: ");
        tch1.display();
        tch2.display();
        tch3.display();
        
        System.out.println("\nThe details of technical staff are: ");
        tec1.display();
        tec2.display();
        tec3.display();
        
        System.out.println("\nThe details of contract staff are: ");
        con1.display();
        con2.display();
        con3.display();
    }
}

class Teaching extends Staff {
    String domain;
    int publication;
    void read()
    {
        super.read();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the domain , total nos of publications");
        domain = sc.nextLine();
        publication = sc.nextInt();
    }
    void display()
    {
        super.display();
        System.out.println("Domain: "+domain+"\tpublication: "+publication);
    }
}

class Technical extends Staff {
    String skills;
    void read()
    {
        super.read();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the skills");
        skills = sc.nextLine();
    }
    void display()
    {
        super.display();
        System.out.println("Skills: "+skills);
    }
}

class Contract extends Staff {
    Double period;
    void read()
    {
        super.read();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the period");
        period = sc.nextDouble();
    }
    void display()
    {
        super.display();
        System.out.println("period: "+period);
    }
}