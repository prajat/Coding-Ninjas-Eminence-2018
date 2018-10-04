import java.util.*;
/**
 * extractuniquecharacters
 */
public class extractuniquecharacters {

    public static void main(String[] args) {

        String str = "raaaaaaaaajjjjjjjjjaaaaaaajjjjjjjtttttt";
        System.out.println(uniqueChar(str));
    }
    
    public static String uniqueChar(String str) {
        
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            if (map.containsKey(cc)) {
                map.put(cc, map.get(cc) + 1);

            } else {
                map.put(cc, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            sb.append(i.getKey().charValue());
            
            
        }
        return sb.toString();

        // HashSet<Character> set = new HashSet<>();
        // for(int i=0;i<str.length();i++){
        //     set.add(str.charAt(i));

        // }
        // Iterator iterator=set.iterator();
        // StringBuilder sb = new StringBuilder();
        // while(iterator.hasNext()){
        //     sb.append(iterator.next());

        // }
        // return sb.toString();
    }
}