public class Problem4_HotWeatherAlertWindows {
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || k < 1 || k > readings.length) throw new IllegalArgumentException("Invalid window size");
        long sum=0;
        for (int i=0; i<k; i++) sum += readings[i];
        long required=(long)k*threshold;
        int alerts = sum >= required ? 1 : 0;
        for (int right=k; right<readings.length; right++) {
            sum += readings[right] - readings[right-k];
            if (sum >= required) alerts++;
        }
        return alerts;
    }
    public static void main(String[] args) {
        System.out.println(countAlerts(new int[]{2,2,2,2,5,5,5,8},3,4));
    }
}
// Recomputing every window: O((n-k+1)*k). Sliding window: O(n) time, O(1) extra space.