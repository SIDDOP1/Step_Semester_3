public class Problem4_MaximizeAreaBetweenTwoBoundaries {
    public static long maxContainerArea(int[] heights) {
        if(heights==null) throw new IllegalArgumentException("Heights cannot be null");
        int left=0,right=heights.length-1; long best=0;
        while(left<right) {
            if(heights[left]<0 || heights[right]<0) throw new IllegalArgumentException("Heights must be non-negative");
            long area=(long)Math.min(heights[left],heights[right])*(right-left);
            best=Math.max(best,area);
            if(heights[left]<=heights[right]) left++;
            else right--;
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxContainerArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
// Brute force checks every pair: O(n^2) time, O(1) space.
// Two pointers: O(n) time, O(1) space; moving the shorter wall cannot lose a better area at the same width.