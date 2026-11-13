public class LibraryBookCatalogDemo {
    static class LibraryBook {
        String title, isbn;
        LibraryBook(String title, String isbn) { this.title = title; this.isbn = (isbn == null || isbn.isEmpty()) ? "PENDING" : isbn; }
        LibraryBook(String title) { this(title, "PENDING"); }
        boolean isCatalogued() { return true; }
        void printStatus() { System.out.printf("%s | %s | Catalogued: %s%n", title, isbn, isCatalogued()); }
    }
    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};
        for (int i = 0; i < titles.length; i++) { LibraryBook book = isbns[i].isEmpty() ? new LibraryBook(titles[i]) : new LibraryBook(titles[i], isbns[i]); book.printStatus(); }
    }
}
