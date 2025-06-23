import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionSets {
    public static ArrayList<Integer> intersectionOfSets(int[] a1,int[] a2){
        ArrayList<Integer> list= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        for (int i = 0; i < a1.length; i++) {
            set.add(a1[i]);
        }
        for (int i : a2) {
            if(set.contains(i)){
                list.add(i);
                set.remove(i);
            }
        }
        return list;
    }
    public static void main(String[] args) {
      int a1[] ={4,1,6,9,5,3};
      int a2[]={1,6,7,3};
      System.out.println(intersectionOfSets(a1, a2));
    }
}
