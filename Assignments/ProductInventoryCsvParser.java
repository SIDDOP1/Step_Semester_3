public class ProductInventoryCsvParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3) { System.out.println("Invalid Record"); return; }
        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", fields[0].trim(), fields[1].trim(), fields[2].trim());
    }
    public static void main(String[] args) { parseInventoryRecord(args.length == 0 ? "Wireless Mouse,WM-2201,150" : String.join(" ", args)); }
}
