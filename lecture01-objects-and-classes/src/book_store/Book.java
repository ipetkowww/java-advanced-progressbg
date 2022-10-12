package book_store;

public class Book {

    private String name;
    private Author author;
    private String isbnCode;
    private int availability;


    public Book(String name, Author author, String isbnCode, int availability) {
        this.name = name;
        this.author = author;
        this.isbnCode = isbnCode;
        this.availability = availability;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + author +
                ", isbnCode='" + isbnCode + '\'' +
                ", availability=" + availability +
                '}';
    }
}
