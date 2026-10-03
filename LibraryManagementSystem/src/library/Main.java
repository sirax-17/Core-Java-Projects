package library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        Librarian librarian = new Librarian("Admin");
        int choice;
        do {

            System.out.println("\n==============================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. View All Books");
            System.out.println("4. Check Availability");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Due Date Reminder");
            System.out.println("8. Fine Calculator");
            System.out.println("9. Generate Report");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {

            case 1:

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author Name: ");
                String author = sc.nextLine();
                Book newBook = new Book(id, title, author);
                library.addBook(newBook);
                break;


            case 2:

                System.out.print("Enter Book ID: ");
                int searchId = sc.nextInt();
                Book book = library.searchBook(searchId);

                if (book != null) {
                    book.displayBook();
                }
                else {
                    System.out.println("Book not found.");
                }
                break;


            case 3:

                library.showBooks();
                break;

            case 4:

                System.out.print("Enter Book ID: ");
                int availableId = sc.nextInt();
                library.checkAvailability(availableId);
                break;

            case 5:

                System.out.print("Enter Book ID: ");
                int issueId = sc.nextInt();
                librarian.approveIssue(library, issueId);
                break;

            case 6:

                System.out.print("Enter Book ID: ");
                int returnId = sc.nextInt();
                library.returnBook(returnId);
                break;

            case 7:

                library.dueDateReminder();
                break;

            case 8:

                System.out.print("Enter Book ID: ");
                int fineId = sc.nextInt();
                long fine = library.calculateFine(fineId);
                System.out.println("Fine: Rs." + fine);
                librarian.collectFine(fine);
                break;

            case 9:

                librarian.generateReport(library);
                break;

            case 10:

                System.out.println("Thank you for using the Library System.");
                break;

            default:
                System.out.println("Invalid choice.");
            }

        } while (choice != 10);
        sc.close();
    }
}