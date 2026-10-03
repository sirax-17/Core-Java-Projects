package voting;

public class User {

    private String username;
    private String password;
    private boolean voted;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        voted = false;
    }
    public String getUsername() {
        return username;
    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    public boolean hasVoted() {
        return voted;
    }
    public void setVoted() {
        voted = true;
    }
}