public class Problem1_ClassTopperFinder {
    // Returns {rowIndex, total}; strict greater-than preserves the earliest row on ties.
    public static int[] findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) throw new IllegalArgumentException("Marks cannot be empty");
        int bestIndex = 0, bestTotal = Integer.MIN_VALUE;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == null || marks[i].length == 0) throw new IllegalArgumentException("Each student needs marks");
            int total = 0;
            for (int mark : marks[i]) {
                if (mark < 0 || mark > 100) throw new IllegalArgumentException("Mark must be 0..100");
                total += mark;
            }
            if (total > bestTotal) { bestTotal = total; bestIndex = i; }
        }
        return new int[]{bestIndex, bestTotal};
    }
    public static void main(String[] args) {
        int[] result = findTopper(new int[][]{{78,85,90},{88,92,79},{65,70,95}});
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}
// Time: O(m*n). Additional space: O(1).