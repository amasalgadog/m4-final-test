package com.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService user;

    @BeforeEach
    public void setUp() {
        user = new UserService("UserTest", 70.0);
    }

    @Test
    public void testUpdateWeightStandard(){
        // Act
        user.updateWeight(75.0);
        // Assert
        assertEquals(75.0, user.getWeight());
    }

    @Test
    public void testUpdateWeightNegative() {
        // Act
        user = new UserService("Bob", 80.0);
        // Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> user.updateWeight(-5.0));
        assertEquals("Weight cannot be negative or zero", exception.getMessage());
    }

    @Test
    public void testUpdateWeightZero() {
        // Act
        user = new UserService("Charlie", 60.0);
        // Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> user.updateWeight(0.0));
        assertEquals("Weight cannot be negative or zero", exception.getMessage());
    }
}
