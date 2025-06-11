package sorting;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int [] arr,int first,int last){
        if(last-first+1==1){
            return;
        }
        int mid=(first+last)/2;
        merge(arr, first, mid);//call for the next first half
        merge(arr, mid+1, last);//call for the next second half
        int p1=first,p2=mid+1;
        int [] temp=new int[last-first+1];
        int p3=0;
        while(p1<=mid && p2<=last){//compairing both halfs
            if(arr[p1]<=arr[p2]){
                temp[p3++]=arr[p1++];
            }else{
                temp[p3++]=arr[p2++];
            }
        }
        while(p1<=mid){//adding remaining of first
            temp[p3++]=arr[p1++];
        }
        while(p2<=last){//adding remaining of second
            temp[p3++]=arr[p2++];
        }
        int j=first;
        for(int i=0;i<temp.length;i++,j++){//copying temp to main array
            arr[j]=temp[i];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of elements: ");
        int n=sc.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter the num,bers one by one : \n");
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        merge(arr,0,n-1);//initial call
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        sc.close();
    }

}