package book_store;

public class BookStoreTest {

    public static void main(String[] args) {
        BookStore bookStore = new BookStore("Orange", "Burgas 056");

        Author james = new Author("James A", "USA, Florida", "123456789");
        Author tom = new Author("Tom C", "UK, London", "99956789");

        Book java = new Book("Java Book", james, "123", 10);
        Book oop = new Book("Object Oriented Programming", tom, "89a", 5);
        Book springBoot = new Book("Spring Boot", tom, "sb456", 2);
        Book deepWork = new Book("Deep Work", james, "681", 0);

        bookStore.addBook(java);
        bookStore.addBook(oop);
        bookStore.addBook(springBoot);
        bookStore.addBook(deepWork);

        printAvailabilityOfBook(java, bookStore);
        printAvailabilityOfBook(deepWork, bookStore);

        bookStore.buyBook(java.getIsbnCode(), 2);
        bookStore.updateStockForBook(deepWork.getIsbnCode(), 20);

        bookStore.printAllBooks();

    }

    public static void printAvailabilityOfBook(Book book, BookStore bookStore) {
        int availabilityOfBook = bookStore.getAvailabilityOfBook(book.getIsbnCode());

        if (availabilityOfBook <= 0) {
            System.out.printf("No availability of %s book.%n", book.getName());
        } else {
            System.out.printf("Book: %s, Availability: %d%n", book.getName(), availabilityOfBook);
        }
    }
}
