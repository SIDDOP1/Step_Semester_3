public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        return new StringBuilder(customerName).reverse().toString();
    }
    public static void main(String[] args) {
        String name = args.length == 0 ? "Sunil" : String.join(" ", args);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }
}
