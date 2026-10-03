package voting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VotingSystem system = new VotingSystem();
        User currentUser = null;
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("     ONLINE VOTING SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Candidates");
            System.out.println("4. Cast Vote");
            System.out.println("5. View Total Votes");
            System.out.println("6. View Result");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

            case 1:
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                system.register(username, password);
                break;

            case 2:
                System.out.print("Enter username: ");
                String loginName = sc.nextLine();
                System.out.print("Enter password: ");
                String loginPassword = sc.nextLine();
                currentUser = system.login(loginName, loginPassword);
                break;

            case 3:
                system.showCandidates();
                break;

            case 4:
                if (currentUser == null) {
                    System.out.println("Please login first.");
                    break;
                }
                system.showCandidates();
                System.out.print("Enter candidate name: ");
                String candidate = sc.nextLine();
                system.vote(currentUser, candidate);
                break;

            case 5:
                system.showVotes();
                break;

            case 6:
                system.showResult();
                break;

            case 7:
                System.out.println("Thank you for using the Voting System.");
                break;

            default:
                System.out.println("Invalid choice.");
            }
        } while (choice != 7);
        sc.close();
    }
}