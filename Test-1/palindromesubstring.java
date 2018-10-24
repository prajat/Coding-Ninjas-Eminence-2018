import java.util.*;
/**
 * palindromesubstring
 */
public class palindromesubstring {

    public static void main(String[] args) {

        System.out.println(countPalindromeSubstrings("aba"));
    }
    
    public static int countPalindromeSubstrings(String s) {
        // Write your code here

        int count=0;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            count++;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    count++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                left = i - 1;
                right = i + 2;
                count++;
                while (left >= 0 && right < s.length()) {
                    if (s.charAt(left) == s.charAt(right)) {
                        count++;
                        left--;
                        right++;

                    } else {
                        break;
                    }
                }
            }

        }
        return count;
    }

    
}