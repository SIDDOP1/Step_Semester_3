public class InventoryBalancer {
    public static void analyzeInventory(int[] a, int[] b) {
        if (a.length != b.length) throw new IllegalArgumentException("Sections must have equal lengths");
        int totalA = 0, totalB = 0, high = Integer.MIN_VALUE, section = 1, index = -1;
        for (int i = 0; i < a.length; i++) {
            totalA += a[i]; totalB += b[i];
            if (a[i] > high) { high = a[i]; section = 1; index = i; }
            if (b[i] > high) { high = b[i]; section = 2; index = i; }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (Section %s, Item %d)%n",
                totalA, totalB, status, high, section == 1 ? "A" : "B", index + 1);
    }
    public static void main(String[] args) { analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30}); }
}
