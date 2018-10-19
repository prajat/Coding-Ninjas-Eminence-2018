import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s1 = s.nextLine();
            map.put(s1, 1);
        }
        String word = s.nextLine();

        wordbreak(word, map, "");
    }

    public static void wordbreak(String word, HashMap<String, Integer> map, String result) {

        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (map.containsKey(prefix)) {
                if (i == word.length()) {
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordbreak(word.substring(i, word.length() - i), map, result + prefix + " ");
            }
        }

    }

}