import java.util.*;

public class Hashing {
    public static void main(String[] args) {
        //Creation
        HashMap<String, Integer> map = new HashMap<>();
        
        //Insertion
        map.put("India", 120);
        map.put("Nepal", 180);
        map.put("USA", 150);

        System.out.println(map);

        map.put("Nepal", 80);  //Update
        System.out.println(map);

        //Searching
        if(map.containsKey("India")) {
            System.out.println("Key is present.");
        }
        else {
            System.out.println("Key is not present.");
        }

        System.out.println(map.get("China"));   //Not present...returns null

        //Iteration 1
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //Iteration 2
        Set <String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        
        //Removing
        map.remove("Nepal");
        System.out.println(map);
    }
}

//Output
//{USA=150, Nepal=180, India=120}
//{USA=150, Nepal=80, India=120}
//Key is present.
//null
//USA
//150
//Nepal
//80
//India
//120
//USA 150
//Nepal 80
//India 120
//{USA=150, India=120}
