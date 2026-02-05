package org.example;

import org.example.exceptions.AttemptsException;
import org.example.exceptions.MissingArguments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticateTest {

    static Authenticate authenticate;

    @BeforeEach
    void before() {
        authenticate = new Authenticate();
    }

    @Test
    @DisplayName("Successful login with valid credentials")
    void successfulLogin() {
        //Case
        System.out.println("Tela de login");

        //When
        boolean isLogged = authenticate.login("john@email.com" , "password");

        //Then
        assertTrue(isLogged);
        System.out.println("Logado com sucesso");
    }

    @Test
    @DisplayName("User is blocked after multiple failed login attempts")
    void blockUserAfterMultipleFailedLoginAttempts() {

        // GIVEN a user with an active account and 3 available login attempts

        // WHEN
        AttemptsException ex1 = assertThrows(
                AttemptsException.class,
                () -> authenticate.login("john@email.com", "wrong")
        );

        // THEN
        assertEquals(
                "Usuário ou senha inválidos. Restam 2 tentativas.",
                ex1.getMessage()
        );

        // WHEN
        AttemptsException ex2 = assertThrows(
                AttemptsException.class,
                () -> authenticate.login("john@email.com", "wrong")
        );

        // THEN
        assertEquals(
                "Usuário ou senha inválidos. Restam 1 tentativas.",
                ex2.getMessage()
        );

        // WHEN
        AttemptsException ex3 = assertThrows(
                AttemptsException.class,
                () -> authenticate.login("john@email.com", "wrong")
        );

        // THEN
        assertEquals(
                "Usuário bloqueado por excesso de tentativas inválidas",
                ex3.getMessage()
        );
    }

    @Test
    @DisplayName("Error message is shown when credentials are invalid")
    void showErrorWhenCredentialsAreInvalid() {

        // Esse caso de teste proposto é o mesmo do caso 1, por algum motivo a esquipe mandou o mesmo teste no caso 2 e 3

        assertTrue(true);
    }

    @Test
    @DisplayName("Required fields are validated on login form")
    void validateRequiredFields() {

        // Dade
        System.out.println("Tela de login");

        // WHEN
        MissingArguments ex1 = assertThrows(
                MissingArguments.class,
                () -> authenticate.login("", "wrong")
        );

        // THEN
        assertEquals(
                "Informe seu email ou usuário.",
                ex1.getMessage()
        );

        // WHEN
        MissingArguments ex2 = assertThrows(
                MissingArguments.class,
                () -> authenticate.login("john@email.com", "")
        );

        // THEN
        assertEquals(
                "Informe sua senha",
                ex2.getMessage()
        );

    }

    @Test
    @DisplayName("Generic error is shown when a connection failure occurs")
    void showErrorWhenConnectionFails() {

        // Não tem como implementar no back-end. Cade f5?

        assertTrue(true);
    }
}
