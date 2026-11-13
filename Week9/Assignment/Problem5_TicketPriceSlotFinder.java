public class Problem5_TicketPriceSlotFinder {
    // Returns the existing index, or the insertion index if the price is absent.
    public static int findSlot(int[] prices, int newPrice) {
        if (prices == null) throw new IllegalArgumentException("Prices cannot be null");
        int low=0, high=prices.length-1;
        while (low<=high) {
            int mid=low+(high-low)/2;
            if (prices[mid]==newPrice) return mid;
            if (prices[mid]<newPrice) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] prices={120,150,200,260};
        System.out.println(findSlot(prices,150));
        System.out.println(findSlot(prices,210));
        System.out.println(findSlot(prices,300));
    }
}
// Binary search: O(log n) time, O(1) additional space. Linear scan: O(n) time, O(1) space.