public class CanteenPaymentDispatchDemo {
    static class Payment { double pay(double amount) { System.out.printf("Paid (cash): Rs %.1f%n", amount); return amount; } }
    static class CardPayment extends Payment {
        double payWithProcessingFee(double amount) { double charged = amount * 1.02; System.out.printf("Charged (card, incl. fee): Rs %.1f%n", charged); return charged; }
    }
    static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) return ((CardPayment) payment).payWithProcessingFee(amount);
        return payment.pay(amount);
    }
    public static void main(String[] args) {
        Payment[] payments = {new CardPayment(), new Payment(), new CardPayment(), new Payment(), new CardPayment()};
        double[] amounts = {100, 50, 200, 75, 120}; double totalCollected = 0;
        for (int i = 0; i < payments.length; i++) totalCollected += processTransaction(payments[i], amounts[i]);
        System.out.printf("Total Collected: Rs %.1f%n", totalCollected);
    }
}
