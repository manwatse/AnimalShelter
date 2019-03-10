package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    private Dog dog;
    private Dog dogReserved;

    private static final double PriceFirstDOG = 500;
    private static final double PriceSecondDOG = 450;
    private static final double PriceThirdDOG = 400;

    @BeforeEach
    void setUp(){
        this.dog = new Dog(1, "test", Gender.MALE);
        this.dogReserved = new Dog(2, "test2", Gender.FEMALE);
        if (!dogReserved.reserveIfPossible("tester")) fail("Could not reserve dog.");
    }

    @AfterEach
    void tearDown(){
        Dog.instantiateTotalDogs(0);
    }

    @Test
    void reserveIfPossible_Boolean_ReturnsTrue() {
        assertTrue(dog.reserveIfPossible("tester"));
    }

    @Test
    void reserveIfPossible_Boolean_ReturnsFalse() {
        assertFalse(dogReserved.reserveIfPossible("tester"));
    }

    @Test
    void getPrice_Double_ReturnsPrice() {
        Dog dog3 = new Dog(3, "Test3", Gender.FEMALE);

        assertEquals(PriceFirstDOG, dog.getPrice());
        assertEquals(PriceSecondDOG, dogReserved.getPrice());
        assertEquals(PriceThirdDOG , dog3.getPrice());

    }
}