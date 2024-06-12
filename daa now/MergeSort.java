import java.util.Random;
import java.util.Scanner;
public class MergeSort {
    private int[] a;
    void input(){
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        System.out.println("enter the total nos: ");
        int n = sc.nextInt();
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=rm.nextInt(1000);
        }
    }
    void display(){
        for(int i:a){
            System.out.print(i + " ");
        }
    }
    void sort(){
        mergesort(0,a.length-1);
    }
    void mergesort(int left,int right){
        int mid;
        if(left<right){
            mid = (left + right)/2;
            mergesort(left,mid);
            mergesort(mid+1,right);
            merge(left,mid,right);
        }
    }
    void merge(int left,int mid,int right){
        int temp[] = new int[a.length];
        for (int i = left; i <= right; i++) {
            temp[i] = a[i];
        }
        int i = left;
        int j = mid +1 ;
        int k = left;
        while (i<=mid && j<=right) {
            if (temp[i]<=temp[j]) {
                a[k++]=temp[i++];
            }
            else{
                a[k++]=temp[j++];
            }
        }
        while (i<=mid) {
            a[k++]=temp[i++];
        }
        while (j<=right) {
            a[k++]=temp[j++];
        }
    }
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        sorter.input();
        System.out.println("Array before sorting");
        sorter.display();
        long startTime = System.nanoTime();
        sorter.sort();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000000.00;
        System.out.println("\nArray after sorting");
        sorter.display();
        System.out.println("\nTime for sorting is "+ duration + " millisecond");
    }
    
}
