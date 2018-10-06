import java.util.*;
/**
 * printkepad
 */
public class printkepad {

    public static void main(String[] args) {

    }

    public static void printKeypad(int input) {
        printKeypad(input, "");
    }

    public static void printKeypad(int input, String outputSoFar) {
        if (input == 0) {
            System.out.println(outputSoFar);
            ;
            return;
        }
        char[] charactersForUnitDigit = findCharactersForUnitDigit(input % 10);
        for (int i = 0; i < charactersForUnitDigit.length; i++) {
            printKeypad(input / 10, charactersForUnitDigit[i] + outputSoFar);
        }
    }

    public static char[] findCharactersForUnitDigit(int n) {
        char[] charForUnitDigit = null;
        switch (n) {
        case 2:
            charForUnitDigit = new char[] { 'a', 'b', 'c' };
            break;
        case 3:
            charForUnitDigit = new char[] { 'd', 'e', 'f' };
            break;
        case 4:
            charForUnitDigit = new char[] { 'g', 'h', 'i' };
            break;
        case 5:
            charForUnitDigit = new char[] { 'j', 'k', 'l' };
            break;
        case 6:
            charForUnitDigit = new char[] { 'm', 'n', 'o' };
            break;
        case 7:
            charForUnitDigit = new char[] { 'p', 'q', 'r', 's' };
            break;
        case 8:
            charForUnitDigit = new char[] { 't', 'u', 'v' };
            break;
        case 9:
            charForUnitDigit = new char[] { 'w', 'x', 'y', 'z' };
            break;
        }
        return charForUnitDigit;
    }
}
