import java.util.*;
/**
 * replacecharacter
 */
public class replacecharacter {

    public static void main(String[] args) {

        String str= "abacada";
        System.out.println(replaceCharacter(str, 'a', 'x'));
    }

    public static String replaceCharacter(String input, char c1, char c2) {
        
    if (input.length() == 0) {
            return input;
        }
        
        
        
         char cc = input.charAt(0);
        String smallans = replaceCharacter(input.substring(1), c1, c2);
        
        if (cc == c1) {
            return c2 + smallans;
        }
        return cc + smallans;

        

        

	}
}