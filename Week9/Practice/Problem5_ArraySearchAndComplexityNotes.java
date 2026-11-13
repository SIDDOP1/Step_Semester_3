public class Problem5_ArraySearchAndComplexityNotes {
    public static int linearSearch(int[] values,int target) {
        for(int i=0;i<values.length;i++) if(values[i]==target) return i;
        return -1;
    }
    public static int binarySearch(int[] sortedValues,int target) {
        int low=0,high=sortedValues.length-1;
        while(low<=high){int mid=low+(high-low)/2;if(sortedValues[mid]==target)return mid;if(sortedValues[mid]<target)low=mid+1;else high=mid-1;}
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{8,2,9,4},9));
        System.out.println(binarySearch(new int[]{2,4,8,9},9));
    }
}
// Unsorted linear search: O(n) time, O(1) space.
// Sorted linear search: O(n) time, O(1) space; sorted binary search: O(log n) time, O(1) space.
// Big-O drops constant factors: O(2n)=O(n). Linear structures are traversed sequentially;
// trees require a traversal such as preorder, inorder, postorder, or level order.