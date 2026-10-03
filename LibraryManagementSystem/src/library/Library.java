package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private HashMap<Integer, LocalDate> issuedBooks = new HashMap<>();
    private final int finePerDay = 10;

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }
    public Book searchBook(int id) {
        for (Book book : books) {

            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }
    public void showBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book book : books) {
            book.displayBook();
        }
    }
    public void checkAvailability(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
        }
        else if (book.isAvailable()) {
            System.out.println(book.getTitle() + " is available.");
        }
        else {
            System.out.println(book.getTitle() + " is currently issued.");
        }
    }
    public void issueBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book already issued.");
            return;
        }
        LocalDate dueDate = LocalDate.now().plusDays(14);
        book.setAvailable(false);
        issuedBooks.put(id, dueDate);
        System.out.println("Book issued successfully.");
        System.out.println("Due date: " + dueDate);
    }
    public long calculateFine(int id) {
        LocalDate dueDate = issuedBooks.get(id);

        if (dueDate == null) {
            return 0;
        }
        if (LocalDate.now().isAfter(dueDate)) {
            long lateDays = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
            return lateDays * finePerDay;
        }
        return 0;
    }
    public void returnBook(int id) {
        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isAvailable()) {
            System.out.println("This book is not issued.");
            return;
        }
        long fine = calculateFine(id);
        book.setAvailable(true);
        issuedBooks.remove(id);
        System.out.println("Book returned successfully.");
        System.out.println("Fine: Rs." + fine);
    }
    public void dueDateReminder() {

        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
            return;
        }
        System.out.println("\n--- DUE DATE REMINDER ---");
        for (Integer id : issuedBooks.keySet()) {
            Book book = searchBook(id);
            LocalDate dueDate = issuedBooks.get(id);
            System.out.println(book.getTitle() + " | Due Date: " + dueDate);
        }
    }
    public void showReport() {
        int available = 0;
        int issued = 0;
        for (Book book : books) {

            if (book.isAvailable()) {
                available++;
            }
            else {
                issued++;
            }
        }
        System.out.println("\n========== LIBRARY REPORT ==========");
        System.out.println("Total Books     : " + books.size());
        System.out.println("Available Books : " + available);
        System.out.println("Issued Books    : " + issued);
        System.out.println("------------------------------------");
        showBooks();
    }
}