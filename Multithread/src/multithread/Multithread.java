/*
 Write a Java program that implements a Multi-thread application
that has thtree threads. First thread generates a random integer for
every 1 second; second thread computes the square of the number
and prints; third thread will print the value of cube of the number
 */
package multithread;
import java.util.Scanner;
import java.util.Random;
public class Multithread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new randomnos());
        t1.start();
    }
}
class randomnos implements Runnable
{
    Random rm = new Random();
    public void run()
    {
        try {
           for (int i = 0; i < 3; i++) {
            int num = rm.nextInt(10);
            
            System.out.println("Thread 1: the number is "+num);
            
            Thread t2 = new Thread(new square(num));
            t2.start();
            
            Thread.sleep(10);
            
            Thread t3 = new Thread(new cube(num));
            t3.start();
            
            Thread.sleep(100);
            
        } 
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
}
class square implements Runnable
{
    int x;
    public square(int num)
    {
        x = num;
    }
    public void run()
    {
        System.out.println("Thread 2: square of "+x+" is "+(x*x));
    }
}
class cube implements Runnable
{
    int x;
    public cube(int num)
    {
        x = num;
    }
    public void run()
    {
        System.out.println("Thread 3: cube of "+x+" is "+(x*x*x));
    }
}
