package sorting;

import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int [] arr,int first ,int last){
        if(last-first+1==1){
            return;
        }
        int pivot = first;
        int l=first+1;
        int r=last;
        int temp;
        while(l<r){
            while(arr[l]<=arr[pivot]){
                l++;
            }
            while(arr[r]>arr[pivot]){
                r--;
            }
            if (l<r) {
                temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter thr number: ");
        int n=sc.nextInt();
        System.out.println("Enter the number sone by one");
        int []  arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        quickSort(arr,0,n-1);
    }
    
}
