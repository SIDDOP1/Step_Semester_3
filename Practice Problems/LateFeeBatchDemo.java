public class LateFeeBatchDemo {
    static class FeeAccount {
        String regNo; double totalFee;
        FeeAccount(String regNo, double totalFee) { this.regNo = regNo; this.totalFee = totalFee; }
        final double calculateLateFee(int daysLate) { return totalFee * 0.01 * daysLate; }
        final void printSummary(int daysLate) { System.out.printf("%s | Total Fee: Rs %.1f | Late Fee: Rs %.1f%n", regNo, totalFee, calculateLateFee(daysLate)); }
    }
    public static void main(String[] args) {
        FeeAccount[] accounts = {new FeeAccount("RA001", 200000), new FeeAccount("RA002", 150000), new FeeAccount("RA003", 180000), new FeeAccount("RA004", 220000)};
        int[] daysLate = {10, 0, -2, 5};
        for (int i = 0; i < accounts.length; i++) if (daysLate[i] > 0) accounts[i].printSummary(daysLate[i]); else System.out.println(accounts[i].regNo + " - On time, no late fee");
    }
}
