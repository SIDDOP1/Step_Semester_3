import java.util.Arrays;

class BookingReceipt {
    // Java cannot make this class final and also allow GroupBookingReceipt to extend it.
    // The base class is extensible, but its fields and exposed data remain immutable.
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers == null ? new String[0] : seatNumbers.clone();
    }

    public String getBookingId() { return bookingId; }
    public String[] getSeatNumbers() { return seatNumbers.clone(); }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= seatNumbers.length) throw new IndexOutOfBoundsException("Invalid seat index");
        String[] updated = seatNumbers.clone();
        updated[index] = newSeat;
        return new BookingReceipt(bookingId, updated);
    }
}

final class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        if (groupSize <= 0) throw new IllegalArgumentException("groupSize must be positive");
        this.groupSize = groupSize;
    }

    public int getGroupSize() { return groupSize; }
}

class BookingSettlement {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        if (receipts != null) {
            for (BookingReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (receipt instanceof GroupBookingReceipt) group++;
                else individual++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}

public class Problem5_ImmutableBookingReceipt {
    public static void main(String[] args) {
        BookingReceipt booking = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = booking.getSeatNumbers();
        seats[0] = "X";
        System.out.println(booking.getSeatNumbers()[0]); // A1

        BookingReceipt updated = booking.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(booking.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(BookingSettlement.processNightlySettlement(batch));
    }
}