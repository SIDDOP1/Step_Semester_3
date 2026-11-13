import java.util.Arrays;
public class Problem2_MergingTwoTokenQueues {
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        if (counterA == null || counterB == null) throw new IllegalArgumentException("Queues cannot be null");
        int[] merged = new int[counterA.length + counterB.length];
        int i=0, j=0, k=0;
        while (i<counterA.length && j<counterB.length) {
            if (counterA[i] <= counterB[j]) merged[k++] = counterA[i++];
            else merged[k++] = counterB[j++];
        }
        while (i<counterA.length) merged[k++] = counterA[i++];
        while (j<counterB.length) merged[k++] = counterB[j++];
        return merged;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeTokens(new int[]{3,8,15,20}, new int[]{5,8,12})));
        System.out.println(Arrays.toString(mergeTokens(new int[]{}, new int[]{4,9})));
    }
}
// Time: O(m+n). Output space: O(m+n), auxiliary working space: O(1). Joining then sorting: O((m+n) log(m+n)).