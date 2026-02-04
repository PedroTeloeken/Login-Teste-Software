package org.example;

import org.junit.jupiter.api.BeforeAll;
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
        assertTrue(false);
    }

    @Test
    @DisplayName("Required fields are validated on login form")
    void validateRequiredFields() {
        assertTrue(false);
    }

    @Test
    @DisplayName("Generic error is shown when a connection failure occurs")
    void showErrorWhenConnectionFails() {
        assertTrue(false);
    }
}
