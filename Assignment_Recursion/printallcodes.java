import java.util.*;
/**
 * printallcodes
 */
public class printallcodes {

    public static void main(String[] args) {

        String s1 = "1123";
        printAllPossibleCodes(s1);
    }
    
    public static void printAllPossibleCodes(String input) {
        // Write your code here

        printAllPossibleCodes(input, "");
    }

    public static void printAllPossibleCodes(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        char firstdigit = getchar(input.charAt(0) - '0');
        int firsttwodigit1 = 0;
        if (input.length() >= 2) {
            firsttwodigit1 = (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0');
        }
        char firsttwodigit = getchar(firsttwodigit1);
        printAllPossibleCodes(input.substring(1), output + firstdigit);
        if (firsttwodigit1 > 10 && firsttwodigit1 <= 26) {
            printAllPossibleCodes(input.substring(2), output + firsttwodigit);
        }

    }

    public static char getchar(int n) {
        return (char) (96 + n);
        
    }
}