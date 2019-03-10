package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    private Cat cat;
    private Cat catReserved;

    private static final double NORMAL_CAT_PRICE = 350;
    private static final double BAD_HABIT_6CHAR_PRICE = 230;

    @BeforeEach
    void setUp(){
        cat = new Cat(1, "test", Gender.MALE, "");
        catReserved = new Cat(2, "test", Gender.MALE, "tester");
        if (!catReserved.reserveIfPossible("Tester")) fail("Cat already reserved.");
    }

    @Test
    void reserveIfPossible_Boolean_ReturnsTrue() {
        assertTrue(cat.reserveIfPossible("Tester"));
    }

    @Test
    void reserveIfPossible_Boolean_ReturnsFalse() {
        assertFalse(catReserved.reserveIfPossible("Tester2"));
    }

    @Test
    void getPrice_Double_ReturnsPrice() {
        assertEquals(NORMAL_CAT_PRICE, cat.getPrice());
        assertEquals(BAD_HABIT_6CHAR_PRICE, catReserved.getPrice());
    }
}