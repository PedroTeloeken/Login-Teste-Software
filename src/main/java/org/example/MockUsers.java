package org.example;

import java.util.ArrayList;
import java.util.List;

public class MockUsers {

    public static List<User> create() {
        List<User> users = new ArrayList<>();

        User admin = new User("admin", "admin@email.com", "123456");
        admin.setAttempts(0);
        admin.setBlocked(false);

        User john = new User("john", "john@email.com", "password");
        john.setAttempts(0);
        john.setBlocked(false);

        User blocked = new User("blocked", "blocked@email.com", "123456");
        blocked.setAttempts(0);
        blocked.setBlocked(true);

        User almostBlocked = new User("almost", "almost@email.com", "123456");
        almostBlocked.setAttempts(0);
        almostBlocked.setBlocked(false);

        User noAttempts = new User("newuser", "new@email.com", "abc123");
        noAttempts.setAttempts(0);
        noAttempts.setBlocked(false);

        User wrongPassword = new User("wrongpass", "wrong@email.com", "qwerty");
        wrongPassword.setAttempts(0);
        wrongPassword.setBlocked(false);

        User testUser = new User("test", "test@email.com", "test123");
        testUser.setAttempts(0);
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
