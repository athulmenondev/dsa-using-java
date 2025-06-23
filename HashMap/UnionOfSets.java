import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfSets {
    public static ArrayList<Integer> unionOfSets(int[] a1,int[] a2){
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> l=new ArrayList<>();
        for (int i = 0; i < a1.length; i++) {
            set.add(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            set.add(a2[i]);
        }
        for (Integer num : set) {
            l.add(num);
        }
        return l;
    }
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,4};
        System.out.println(unionOfSets(arr1, arr2));
    }
}
