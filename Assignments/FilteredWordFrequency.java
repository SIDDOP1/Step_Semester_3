import java.util.*;

public class FilteredWordFrequency {
    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stop = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        String clean = feedback.toLowerCase().replace(".", " ").replace(",", " ").replace("!", " ").replace("?", " ").replace(":", " ").replace(";", " ");
        Map<String, Integer> counts = new HashMap<>();
        for (String word : clean.trim().split("\\s+")) if (!word.isEmpty() && !stop.contains(word)) counts.merge(word, 1, Integer::sum);
        counts.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
    public static void main(String[] args) { printFilteredWordFrequency(args.length == 0 ? "The mentor was great, the session was great and clear." : String.join(" ", args)); }
}
