package org.example;

import java.util.List;
import java.util.Objects;

public class Authenticate {

    List<User> userList = MockUsers.create();

    public boolean login(String email, String password) {

        for (User user : userList) {

            if (Objects.equals(user.getEmail(), email)) {

                if (Objects.equals(user.getPassword(), password)) {
                    user.resetAttempts();
                    return true;
                }

                user.decrementAttempts();

                if (user.getAttempts() == 0) {
                    user.setBlocked(true);
                    throw new AttemptsException(
                            "Usuário bloqueado por excesso de tentativas inválidas"
                    );
                }

                throw new AttemptsException(
                        "Usuário ou senha inválidos. Restam " + user.getAttempts() + " tentativas."
                );

            }
        }

        throw new InvalidLoginException("Usuário não encontrado");
    }
}

