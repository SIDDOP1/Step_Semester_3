public class AccountBatchPaymentsDemo {
    static class FeeAccount { void pay(double amount) { System.out.println("Paid in one go (day-scholar account)"); } }
    static class HostelFeeAccount extends FeeAccount { @Override void pay(double amount) { System.out.println("Paid in two installments (hostel account)"); } }
    static void processPayment(FeeAccount account, double amount) { if (account instanceof HostelFeeAccount) ((HostelFeeAccount) account).pay(amount); else account.pay(amount); }
    public static void main(String[] args) {
        FeeAccount[] accounts = {new HostelFeeAccount(), new HostelFeeAccount(), new FeeAccount(), new FeeAccount()};
        int hostel = 0, dayScholar = 0;
        for (FeeAccount account : accounts) { processPayment(account, 60000); if (account instanceof HostelFeeAccount) hostel++; else dayScholar++; }
        System.out.printf("Hostel accounts processed: %d | Day-scholar accounts processed: %d%n", hostel, dayScholar);
    }
}
