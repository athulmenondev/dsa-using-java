import java.util.HashMap;

public class MajorityElement {
    public static void printMajorityElement(int[] arr){
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if(map.get(key)>arr.length/3){
                System.out.println(key);
            }
        }
    }
    public static void main(String[] args) {
        int a[]={1,2};
        printMajorityElement(a);
        
    }
}
