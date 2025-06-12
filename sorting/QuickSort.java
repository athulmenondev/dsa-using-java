package sorting;

import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int [] arr,int first ,int last){
        if(first>=last){
            return;
        }
        int pivot = arr[first];//setting the pivot element
        int l=first+1;
        int r=last;
        int temp;
        while(l<=r){
            while(l<=last && arr[l]<=pivot){//move left pointer
                l++;
            }//8
            while(r>first && arr[r]>pivot){//move right pointer
                r--;
            }//3
            if (l<r) {
                System.out.println("internal swap between "+ arr[l]+" and "+arr[r]);//in between swap
                temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
            }
        }
        System.out.println("external swap between "+ pivot+" and "+arr[r]);//swaping between pivot
        arr[first]=arr[r];
        arr[r]=pivot;
        quickSort(arr, first, r-1);//next call for 1st half
        quickSort(arr, r+1, last);//next call for 2nd half
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
        quickSort(arr,0,n-1);//inital call
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }

    
}
