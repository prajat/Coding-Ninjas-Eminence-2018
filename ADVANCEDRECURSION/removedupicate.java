
public class Solution {

    public static String removeConsecutiveDuplicates(String input) {
        // Write your code here
        if (input.length() == 1) {
            return input;
        }
        char cc = input.charAt(0);
        String smallans = removeConsecutiveDuplicates(input.substring(1));
        if (cc == smallans.charAt(0)) {
            return smallans;
        }
        return cc + smallans;

    }

}