package voting;

import java.util.HashMap;

public class VotingSystem {

    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, Integer> candidates = new HashMap<>();

    public VotingSystem() {
        candidates.put("Luffy", 0);
        candidates.put("Sanji", 0);
        candidates.put("Zoro", 0);
    }

    public void register(String username, String password) {

        if (users.containsKey(username)) {
            System.out.println("Username already registered.");
            return;
        }
        users.put(username, new User(username, password));
        System.out.println("Registration successful.");
    }

    public User login(String username, String password) {
        User user = users.get(username);

        if (user != null && user.checkPassword(password)) {
            System.out.println("Login successful.");
            return user;
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    public void showCandidates() {
        System.out.println("\n--- CANDIDATE LIST ---");
        for (String name : candidates.keySet()) {
            System.out.println(name);
        }
    }

    public void vote(User user, String candidate) {

        if (user.hasVoted()) {
            System.out.println("You have already voted.");
            return;
        }
        if (!candidates.containsKey(candidate)) {
            System.out.println("Invalid candidate.");
            return;
        }
        int votes = candidates.get(candidate);
        candidates.put(candidate, votes + 1);
        user.setVoted();
        System.out.println("Vote cast successfully.");
    }

    public void showVotes() {
        System.out.println("\n--- TOTAL VOTES ---");
        for (String name : candidates.keySet()) {
            System.out.println(name + " : " + candidates.get(name));
        }
    }

    public void showResult() {
        String winner = null;
        String runnerUp = null;
        for (String name : candidates.keySet()) {

            if (winner == null ||
                    candidates.get(name) > candidates.get(winner)) {
                		runnerUp = winner;
                		winner = name;
            		} else if (runnerUp == null ||
                    candidates.get(name) > candidates.get(runnerUp)) {
            			runnerUp = name;
            		}
        }

        System.out.println("\n--- ELECTION RESULT ---");
        System.out.println("Winner    : " + winner +" - " + candidates.get(winner) + " votes");
        System.out.println("Runner-Up : " + runnerUp +" - " + candidates.get(runnerUp) + " votes");
    }
}