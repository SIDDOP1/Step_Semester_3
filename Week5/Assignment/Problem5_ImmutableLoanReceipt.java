import java.util.Arrays;

class LoanReceipt {
    // The PDF asks for a final class and also requires ReferenceOnlyLoanReceipt
    // to extend it. Those two requirements conflict in Java. The base class
    // is therefore non-final, while its state is immutable (all fields final).
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds == null ? new String[0] : bookIds.clone();
    }

    public String getMemberId() { return memberId; }
    public String[] getBookIds() { return bookIds.clone(); }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) throw new IndexOutOfBoundsException("Invalid book index");
        String[] corrected = bookIds.clone();
        corrected[index] = newId;
        return new LoanReceipt(memberId, corrected);
    }
}

final class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() { return roomNumber; }
}

class CirculationLedger {
    private static final String BRANCH_CODE;

    static {
        BRANCH_CODE = "PT-LIB";
    }

    public static String getBranchCode() { return BRANCH_CODE; }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0;
        if (receipts != null) {
            for (LoanReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) referenceOnly++;
                else regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | " + regular + " regular";
    }
}

public class Problem5_ImmutableLoanReceipt {
    public static void main(String[] args) {
        LoanReceipt receipt = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = receipt.getBookIds();
        ids[0] = "HACKED";
        System.out.println(receipt.getBookIds()[0]); // BK-100

        LoanReceipt corrected = receipt.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(receipt.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] nightly = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(nightly));
    }
}