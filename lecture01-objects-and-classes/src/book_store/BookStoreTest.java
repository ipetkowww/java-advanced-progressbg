package book_store;

public class BookStoreTest {

    public static void main(String[] args) {
        BookStore bookStore = new BookStore("Orange", "Burgas 056");

        Author james = new Author("James A", "USA, Florida", "123456789");
        Author tom = new Author("Tom C", "UK, London", "99956789");

        Book java = new Book("Java Book", james, "123", 10);
        Book oop = new Book("Object Oriented Programming", tom, "89a", 5);
        Book springBoot = new Book("Spring Boot", tom, "sb456", 2);
        Book deepWork = new Book("Deep Work", james, "681", 1);
        Book opsa = new Book("Opsa", james, "1", 1);

        bookStore.addBook(java);
        bookStore.addBook(oop);
        bookStore.addBook(springBoot);
        bookStore.addBook(deepWork);

        printAllBooksIn(bookStore);

        buyBook(java, 11, bookStore);
        buyBook(opsa, 3, bookStore);
        buyBook(oop, 5, bookStore);

        printAllBooksIn(bookStore);

        bookStore.updateStockForBook("89a", 100);

        printAllBooksIn(bookStore);

    }

    public static void printAllBooksIn(BookStore bookStore) {
        for (Book book : bookStore.getAllBooks()) {
            System.out.println(book);
        }
    }

    public static void buyBook(Book book, int quantity, BookStore bookStore) {
        boolean isBought = bookStore.buyBook(book.getIsbnCode(), quantity);
        if (isBought) {
            System.out.printf("You successfully bought '%s' book.%n", book.getName());
        } else {
            if (bookStore.isBookAvailable(book)) {
                System.out.printf("You want to buy %d but currently we have only %d quantity.%n", quantity, book.getAvailability());
            } else {
                System.out.printf("Book '%s' does not exist in the bookstore.%n", book.getName());
            }
        }
    }

}
