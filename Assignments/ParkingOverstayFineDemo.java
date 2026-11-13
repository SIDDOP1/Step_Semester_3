public class ParkingOverstayFineDemo {
    static class ParkingTicket {
        String vehicleNo; double ratePerMinute;
        ParkingTicket(String vehicleNo, double ratePerMinute) { this.vehicleNo = vehicleNo; this.ratePerMinute = ratePerMinute; }
        final double calculateFine(int overstayMinutes) { return overstayMinutes * ratePerMinute; }
        final void printReceipt(int overstayMinutes) { System.out.printf("%s - Fine: Rs %.1f%n", vehicleNo, calculateFine(overstayMinutes)); }
    }
    public static void main(String[] args) {
        String[] numbers = {"TN09AB1234", "TN22CD5678", "TN09EF9012", "TN10GH3456"};
        double[] rates = {2, 2, 3, 2}; int[] minutes = {15, 0, -5, 8};
        for (int i = 0; i < numbers.length; i++) { ParkingTicket ticket = new ParkingTicket(numbers[i], rates[i]); if (minutes[i] > 0) ticket.printReceipt(minutes[i]); else System.out.println(numbers[i] + " - No fine, within allotted time"); }
    }
}
