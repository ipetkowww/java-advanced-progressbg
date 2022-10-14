package book_store;

import java.util.List;

public class BookStore {

    private final String name;
    private final String address;
    private final ArrayBook storage;

    public BookStore(String name, String address) {
        this.name = name;
        this.address = address;
        this.storage = new ArrayBook();
    }

    public int getAvailabilityOfBook(String isbnCode) {
        Book book = this.storage.hasElement(isbnCode);
        if (book == null) {
            return -1;
        }
        return book.getAvailability();
    }

    public boolean buyBook(String isbnCode, int quantity) {
        int availabilityOfBook = getAvailabilityOfBook(isbnCode);

        if (availabilityOfBook <= 0) {
            return false;
        }
        Book book = this.storage.hasElement(isbnCode);
        book.setAvailability(availabilityOfBook - quantity);
        return true;
    }

    public boolean updateStockForBook(String isbnCode, int quantity) {
        Book book = this.storage.hasElement(isbnCode);
        if (book == null) {
            return false;
        }
        book.setAvailability(book.getAvailability() + quantity);
        return true;
    }

    public void addBook(Book book) {
        this.storage.addBook(book);
    }

    public void printAllBooks() {
        for (Book book : this.storage.getBooks()) {
            System.out.println(book);
        }
    }
}
