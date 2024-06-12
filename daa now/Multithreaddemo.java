import java.util.Random;
class square implements Runnable{
    int x;
    square(int num){
        x = num;
    }
    public void run(){
        System.out.printf("Thread 2: square of random number %d is %d\n",x,x*x);
    }
}
class cube implements Runnable{
    int x;
    cube(int num){
        x = num;
    }
    public void run(){
        System.out.printf("Thread 3: cube of random number %d is %d\n",x,x*x*x);
    }
}
class Randomint implements Runnable{
    int num;
    Random r = new Random();
    public void run(){
        try{
            for(int i = 0; i < 5; i++) {
                num = r.nextInt(100);
                System.out.println("Thread 1:The random integer is "+num);

                Thread t2 = new Thread(new square(num));
                t2.start();

                Thread t3 = new Thread(new cube(num));
                t3.start();

                Thread.sleep(1000);
                System.out.println("-------------------------------------------\n");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
public class Multithreaddemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Randomint());
        t1.start();
    }
    
}


