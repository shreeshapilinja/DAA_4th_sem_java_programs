/*
Sort a given set of n integer elements using Merge Sort method and
compute its time complexity. Run the program for varied values of n
> 5000, and record the time taken to sort. Plot a graph of the time
taken versus n on graph sheet. The elements can be read from a file
or can be generated using the random number generator.
Demonstrate using Java how the divideand- conquer method works
 */
package mergesort;
import java.util.*;
public class Mergesort {
    static int[] arr;
    static int n;
    static void mergesort(int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergesort(left,mid);
            mergesort(mid+1,right);
            merge(left,mid,right);
        }
    }
    static void merge(int left,int mid,int right){
        int i = left;
        int j = mid + 1;
        int k = left;
        int temp[] = arr.clone();
        while (i<=mid && j<=right) {
            if(temp[i]<=temp[j]){
                arr[k++] = temp[i++];
            }else{
                arr[k++] = temp[j++];
            }
        }
        while (i<=mid) {
            arr[k++] = temp[i++];
        }
        while (j<=right) {
            arr[k++] = temp[j++];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        System.out.println("Enter the nos of elements: ");
        n = sc.nextInt();
        arr = new int[n];
        System.out.println("unsorted array");
        for (int i = 0; i < n; i++) {
            arr[i] = rm.nextInt(10);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        long start = System.nanoTime();
        mergesort(0,n-1);
        long stop = System.nanoTime();
        System.out.println("\nsorted aray");
        double time = (stop-start)/1000000.00;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\ntime taken is "+time);
    }
    
}
