import java.util.ArrayList;
import java.util.HashMap;

public class Itinerary {
    public static String findStart(HashMap<String,String> map1){
        HashMap<String,String> map2= new HashMap<>();
        for (String key : map1.keySet()) {
            map2.put(map1.get(key), key);
        }
        for (String key: map1.keySet()) {
            if(!map2.containsKey(key)  && map1.containsKey(key)){
                 return key;
            }
        }
        return null;
    }
    public static void findRoute(HashMap<String,String> map1,String start){
        System.out.print(start+"  --->  ");
        if(!map1.containsKey(start)){
            return;
        }
        findRoute(map1, map1.get(start));
    }
    public static void main(String[] args) {
        HashMap<String,String> n=new HashMap<>();
        n.put("Chennai","Bangaluru");
        n.put("Mumbai","Delhi");
        n.put("Goa","Chennai");
        n.put("Delhi","Goa");
        String start=findStart(n);
        findRoute(n, start);
    }
}