package library;

public class Librarian {

    private String name;

    public Librarian(String name) {
        this.name = name;
    }
    public void approveIssue(Library library, int bookId) {
        System.out.println("Issue approved by " + name);
        library.issueBook(bookId);
    }
    public void collectFine(long fine) {

        if (fine > 0) {
            System.out.println("Fine collected: Rs." + fine);
        }
        else {
            System.out.println("No fine to collect.");
        }
    }
    public void generateReport(Library library) {
        library.showReport();
    }
}