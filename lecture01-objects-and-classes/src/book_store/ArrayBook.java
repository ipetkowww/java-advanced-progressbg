package book_store;

import java.util.ArrayList;
import java.util.List;

public class ArrayBook {

    private List<Book> books;

    public ArrayBook() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Book getBook(int index) {
        return this.books.get(index);
    }

    public Book hasElement(String isbnCode) {
        return this.books.stream()
                .filter(b -> b.getIsbnCode().equals(isbnCode))
                .findFirst()
                .orElse(null);
    }

    public int size() {
        return this.books.size();
    }

    public List<Book> getBooks() {
        return books;
    }
}
