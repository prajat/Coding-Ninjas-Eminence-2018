import java.util.*;

/**
 * checkAB
 */
public class checkAB {

    public static void main(String[] args) {

    }

    public static boolean checkAB(String input) {
        boolean smallAnswer = false;
        if (input.length() == 0) {
            return true;
        }
        if (input.length() == 1) {
            if (input.charAt(0) == 'a') {
                smallAnswer = true;
                input = input.substring(1);
            }
        } else if (input.length() == 2) {
            if (input.charAt(0) == 'a' && input.charAt(1) == 'a') {
                smallAnswer = true;
                input = input.substring(2);
            }
        } else if (input.length() >= 3) {
            if (input.charAt(0) == 'a' && input.substring(1, 3).equals("bb")) {
                smallAnswer = true;
                input = input.substring(3);
            } else if (input.charAt(0) == 'a' && input.charAt(1) == 'a') {
                smallAnswer = true;
                input = input.substring(1);
            }
        }
        return smallAnswer && checkAB(input);
    }
}