public class TrafficSignalStreak {
    public static void findLongestStreak(String log) {
        if (log.isEmpty()) { System.out.println("No signal readings"); return; }
        char best = log.charAt(0), current = best;
        int bestCount = 1, count = 1;
        for (int i = 1; i < log.length(); i++) {
            if (log.charAt(i) == current) count++;
            else { current = log.charAt(i); count = 1; }
            if (count > bestCount) { bestCount = count; best = current; }
        }
        System.out.printf("Longest Streak: '%c' repeated %d times%n", best, bestCount);
    }
    public static void main(String[] args) { findLongestStreak("RRGGGYRR"); }
}
