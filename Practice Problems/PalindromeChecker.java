public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--)
            if (text.charAt(left) != text.charAt(right)) return false;
        return true;
    }
    public static boolean isPalindromeRecursive(String text) { return recursive(text, 0, text.length() - 1); }
    private static boolean recursive(String text, int left, int right) {
        if (left >= right) return true;
        return text.charAt(left) == text.charAt(right) && recursive(text, left + 1, right - 1);
    }
    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) { char t = chars[i]; chars[i] = chars[j]; chars[j] = t; }
        return text.equals(new String(chars));
    }
    public static void main(String[] args) {
        String text = args.length == 0 ? "madam" : String.join(" ", args);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                label(isPalindromeIterative(text)), label(isPalindromeRecursive(text)), label(isPalindromeArrayReversal(text)));
    }
    private static String label(boolean value) { return value ? "Palindrome" : "Not Palindrome"; }
}
