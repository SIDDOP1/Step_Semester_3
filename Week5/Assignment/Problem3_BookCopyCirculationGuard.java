class BookInventory {
    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) throw new IllegalArgumentException("copiesTotal must be positive");
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) copiesAvailable--;
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) copiesAvailable++;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class Problem3_BookCopyCirculationGuard {
    public static void main(String[] args) {
        BookInventory inventory = new BookInventory(3);
        inventory.checkOut();
        inventory.checkOut();
        inventory.checkOut();
        inventory.checkOut(); // silently rejected
        System.out.println(inventory.getCopiesAvailable()); // 0

        inventory.checkIn();
        inventory.checkIn();
        inventory.checkIn();
        inventory.checkIn(); // silently rejected
        System.out.println(inventory.getCopiesAvailable()); // 3
    }
}