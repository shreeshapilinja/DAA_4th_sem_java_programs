package quicksort;
import java.util.*;
public class Quicksort {
    static int n;
    static int[] arr;
    static int partition(int left,int right)
    {
        int pivot = arr[left];
        int i = left;
        int j = right+1;
        do {
            do {
                i++;
            } while (arr[i]<pivot && i<right);
            do{
                j--;
            } while (arr[j]>pivot);
            swap(i,j);
        } while (i<j);
        swap(i,j);
        swap(left,j);
        return j;
    }
    static void swap(int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void quicksort(int left,int right)
    {
        if(left<right){
            int s = partition(left,right);
            quicksort(left,s-1);
            quicksort(s+1,right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        System.out.println("Enter the array size");
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rm.nextInt(10);
        }
        System.out.println("array without sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        long start = System.nanoTime();
        quicksort(0,n-1);
        long stop = System.nanoTime();
        System.out.println("\nArray after sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        double time = (stop-start)/100000.00;
        System.out.println("\ntime taken is "+time+" millisecond");
        
    }
    
}
