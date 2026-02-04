package org.example.mock;

import org.example.User;

import java.util.ArrayList;
import java.util.List;

public class MockUsers {

    public static List<User> create() {
        List<User> users = new ArrayList<>();

        User admin = new User(1,"admin", "admin@email.com", "123456");
        admin.setBlocked(false);

        User john = new User(2,"john", "john@email.com", "password");
        john.setBlocked(false);

        User blocked = new User(3, "blocked", "blocked@email.com", "123456");
        blocked.setBlocked(true);

        User almostBlocked = new User(4,"almost", "almost@email.com", "123456");
        almostBlocked.setBlocked(false);

        User noAttempts = new User(5, "newuser", "new@email.com", "abc123");
        noAttempts.setBlocked(false);

        User wrongPassword = new User(6, "wrongpass", "wrong@email.com", "qwerty");
        wrongPassword.setBlocked(false);

        User testUser = new User(7, "test", "test@email.com", "test123");
        testUser.setBlocked(false);

        users.add(admin);
        users.add(john);
        users.add(blocked);
        users.add(almostBlocked);
        users.add(noAttempts);
        users.add(wrongPassword);
        users.add(testUser);

        return users;
    }
}
