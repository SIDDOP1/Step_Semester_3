import java.util.Arrays;

public class Problem1_NoticeBoardShuffle {
    // Sorts scores in ascending order and returns {passes, swaps}.
    static int[] bubbleStats(int[] scores) {
        int passes=0, swaps=0;
        for(int end=scores.length-1; end>0; end--) {
            boolean swapped=false;
            passes++; // Count each sweep, including the final no-swap sweep.
            for(int i=0;i<end;i++) {
                if(scores[i]>scores[i+1]) {
                    int temp=scores[i]; scores[i]=scores[i+1]; scores[i+1]=temp;
                    swaps++; swapped=true;
                }
            }
            if(!swapped) break;
        }
        return new int[]{passes,swaps};
    }
    public static void main(String[] args) {
        int[] a={5,1,4,2,8};
        int[] stats=bubbleStats(a);
        System.out.println(Arrays.toString(a));
        System.out.println("passes = "+stats[0]+", swaps = "+stats[1]);
        int[] b={1,2,3,4};
        stats=bubbleStats(b);
        System.out.println(Arrays.toString(b));
        System.out.println("passes = "+stats[0]+", swaps = "+stats[1]);
    }
}
// Example 1: [1, 2, 4, 5, 8], passes=3, swaps=4.
// Example 2: [1, 2, 3, 4], passes=1, swaps=0.
// Time: O(n^2) worst, O(n) best for already sorted input. Extra space O(1).
// Stable: YES; equal values are never swapped. Sorted input needs one sweep to prove no swap is needed.