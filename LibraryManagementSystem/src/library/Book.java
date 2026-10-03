package library;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        available = true;
    }
    public int getBookId() {
        return bookId;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public void displayBook() {
        String status;

        if (available) {
            status = "Available";
        } else {
            status = "Issued";
        }
        System.out.println(bookId + " | " + title + " | " + author + " | " + status);
    }
}