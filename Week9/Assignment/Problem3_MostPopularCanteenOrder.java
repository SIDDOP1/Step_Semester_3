import java.util.HashMap;
import java.util.Map;
public class Problem3_MostPopularCanteenOrder {
    public static String[] mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) throw new IllegalArgumentException("Orders cannot be empty");
        Map<String,Integer> counts = new HashMap<>();
        for (String item : orders) counts.put(item, counts.getOrDefault(item,0)+1);
        String best = orders[0];
        int max = counts.get(best);
        for (String item : orders) {
            int count = counts.get(item);
            if (count > max) { max = count; best = item; }
        }
        return new String[]{best, Integer.toString(max)};
    }
    public static void main(String[] args) {
        String[] result = mostPopular(new String[]{"dosa","idli","vada","dosa","idli","dosa","tea"});
        System.out.println("(\"" + result[0] + "\", " + result[1] + ")");
        String[] tie = mostPopular(new String[]{"tea","coffee","coffee","tea"});
        System.out.println("(\"" + tie[0] + "\", " + tie[1] + ")");
    }
}
// Expected average time: O(n), additional space: O(u), u = distinct items.
// A repeated full-list count for each item can take O(n^2) time and O(1) extra space.