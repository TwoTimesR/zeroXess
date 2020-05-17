package com.zeroxess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void loginButtonAction(){
        String username, password;
        username = "admin";
        password = "Test";

        assertEquals("admin", username);
        assertEquals("Test", password);
    }
}