public class DuplicateSeats {
    public static void checkDuplicateSeats(int[] seats) {
        boolean found = false;
        for (int i = 0; i < seats.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) if (seats[k] == seats[i]) alreadyPrinted = true;
            if (alreadyPrinted) continue;
            for (int j = i + 1; j < seats.length; j++) if (seats[i] == seats[j]) {
                System.out.println("Duplicate Seat Number Found: " + seats[i]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No Duplicate Seats Found");
    }
    public static void main(String[] args) { checkDuplicateSeats(new int[]{101, 102, 103, 102, 105}); }
}
