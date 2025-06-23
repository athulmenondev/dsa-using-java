import java.util.HashMap;

public class Sumof2Numbers {
    public static int[] findSumOf2(int[] arr,int sum){
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //System.out.println("Inside loop "+i+"th iteration");
            int comp=sum-arr[i];
            //System.out.println("Compliment Of the NUmber "+arr[i]+" is "+comp);
            if(map.containsKey(arr[i])){
                //System.out.println(map.get(comp)+"<---> "+i);
                return (new int[]{map.get(arr[i]),i});
            }else{
                map.put(comp, i);
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int a[]={2,4,1,5,3};
        int t[]=findSumOf2(a, 8);
        System.out.println(t[0]+" "+t[1]);
    }
}
