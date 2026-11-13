public class WordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortWords = 0, mediumWords = 0, longWords = 0;
        for (String word : review.trim().split("\\s+")) {
            if (word.isEmpty()) continue;
            int n = word.length();
            if (n <= 4) shortWords++; else if (n <= 8) mediumWords++; else longWords++;
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortWords, mediumWords, longWords);
    }
    public static void main(String[] args) { classifyWordLengths("This movie was absolutely fantastic and thrilling"); }
}
