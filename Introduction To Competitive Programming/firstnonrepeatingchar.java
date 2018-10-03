import java.util.*;

/*
	- You are given a string, that can contain repeating characters.
	- Your task is to return the first character in this string that does not repeat. i.e., occurs exactly once
	- The string will contain characters only from English alphabet set, i.e., ('A' - 'Z') and ('a' - 'z');

*/

public class firstnonrepeatingchar {
    public static char firstNonRepeatingChar(String str) {
        // write your code here.
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            
            if (map.containsKey(cc)) {
                map.put(cc, map.get(cc) + 1);
            } else {
                map.put(cc, 1);
            }
        }
        char ans=' ';

        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() == 1) {
                ans = i.getKey().charValue();
                break;
            }
        }
        
        if (ans == ' ') {
            return str.charAt(0);
        }

        return ans;
    }
    
}
