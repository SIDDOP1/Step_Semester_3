public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < text.length(); i++) counts[text.charAt(i)]++;
        for (int i = 0; i < text.length(); i++) if (counts[text.charAt(i)] == 1) return text.charAt(i);
        return '\0';
    }
    public static void main(String[] args) {
        String text = args.length == 0 ? "swiss" : String.join(" ", args);
        char answer = findFirstNonRepeatingChar(text);
        if (answer == '\0') System.out.println("No Non-Repeating Character Found");
        else System.out.println("First Non-Repeating Character: '" + answer + "'");
    }
}
