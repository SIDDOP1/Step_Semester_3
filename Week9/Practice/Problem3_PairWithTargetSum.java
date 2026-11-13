import java.util.HashSet;
import java.util.Set;
public class Problem3_PairWithTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        if(nums==null) throw new IllegalArgumentException("Array cannot be null");
        Set<Integer> seen=new HashSet<>();
        for(int value:nums) {
            int complement=target-value;
            if(seen.contains(complement)) return true;
            seen.add(value);
        }
        return false;
    }
    public static boolean hasPairWithSumBruteForce(int[] nums,int target) {
        for(int i=0;i<nums.length;i++) for(int j=i+1;j<nums.length;j++)
            if((long)nums[i]+nums[j]==target) return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2,7,11,15},9));
        System.out.println(hasPairWithSum(new int[]{3,4,6},20));
        System.out.println(hasPairWithSum(new int[]{3,3},6));
    }
}
// Brute force: O(n^2) time, O(1) extra space.
// Hash set: O(n) expected time, O(n) extra space. Distinct indices are guaranteed by checking before insertion.