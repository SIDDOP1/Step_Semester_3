public class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int length = Math.min(original.length(), typed.length()), matched = 0, first = -1;
        for (int i = 0; i < length; i++) {
            if (original.charAt(i) == typed.charAt(i)) matched++;
            else if (first == -1) first = i;
        }
        int total = Math.max(original.length(), typed.length());
        double accuracy = total == 0 ? 100.0 : matched * 100.0 / total;
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, total, accuracy);
        if (first == -1 && original.length() != typed.length()) first = length;
        if (first == -1) System.out.println("No Mismatches");
        else {
            char expected = first < original.length() ? original.charAt(first) : '\0';
            char actual = first < typed.length() ? typed.charAt(first) : '\0';
            System.out.printf("First Mismatch at position %d ('%s' vs '%s')%n", first + 1,
                    expected == '\0' ? "<end>" : String.valueOf(expected), actual == '\0' ? "<end>" : String.valueOf(actual));
        }
    }
    public static void main(String[] args) { checkTypingAccuracy("hello world", "hello worlt"); }
}
