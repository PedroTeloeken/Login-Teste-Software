package org.example;

public class User {

    String username;
    String email;
    String password;
    int attempts;
    boolean blocked;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.attempts = attempts;
        this.blocked = blocked;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void incrementAttempts() {
        this.attempts += 1;
    }

    public void resetAttempts() {
        this.attempts = 0;
    }



}
