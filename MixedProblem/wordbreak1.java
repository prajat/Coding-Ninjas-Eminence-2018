import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
       // HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            String s1 = s.nextLine();
            //map.put(s1, 1);
            set.add(s1);
        }
        String word = s.nextLine();
        // Iterator iterator = set.iterator();
        // whiel(iterator.hasNext()){
        //     System.out.println(iterator.next());
        // }

        wordbreak(word, set, "");
    }

    public static void wordbreak(String word, HashSet<String> set, String result) {

        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (set.contains(prefix)) {
                if (i == word.length()) {
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordbreak(word.substring(i, word.length() - i), set, result + prefix + " ");
            }
        }

    }

}