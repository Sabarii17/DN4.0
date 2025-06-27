package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest{

    private App app;

    @Before
    public void setUp() {
        app = new App();
        System.out.println("Setup complete.");
    }

    @After
    public void tearDown() {
        app = null;
        System.out.println("Teardown complete.");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 2, b = 3;

        // Act
        int result = app.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 4, b = 5;

        // Act
        int result = app.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }
}
