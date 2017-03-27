package classes;

public class User {

    private final int userID;
    private final String username;
    private final String password;
    private final int balance;

    public User(int userID, String username, String password, int balance) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }
    
    
    
    
}
