public class Palindrom {

    /* Palindrome check of the given string with recursion */
    public static boolean isPalRec(String str, int s, int e) {
        // If there is only one character
        if (s == e)
            return true;
        // If first and last characters do not match
        if ((str.charAt(s)) != (str.charAt(e)))
            return false;
        // If there are more than two characters, check if middle substring is also palindrome or not.
        if (s < e + 1)
            return isPalRec(str, s + 1, e - 1);
        return true;
    }

    /* Checks whether the given string is palindrome or not */
    public static boolean isPalindrome(String str) {
        int n = str.length();
        // An empty string is considered as palindrome
        if (n == 0)
            return true;
        return isPalRec(str, 0, n - 1);
    }
