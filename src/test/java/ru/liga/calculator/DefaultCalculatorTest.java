package ru.liga.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DefaultCalculatorTest {

    @Test
    public void testEmptyString() {
        StudyCalculator calculator = new StudyCalculator();
        assertEquals(0, calculator.sum(""));
    }

    @Test
    public void testSingleNumber() {
        StudyCalculator calculator = new StudyCalculator();
        assertEquals(5, calculator.sum("5"));
    }

    @Test
    public void testTwoNumbers() {
        StudyCalculator calculator = new StudyCalculator();
        assertEquals(8, calculator.sum("3 5"));
    }

    @Test
    public void testMoreThanTwoNumbers() {
        StudyCalculator calculator = new StudyCalculator();
        assertThrows(RuntimeException.class, () -> calculator.sum("1 2 3"));
    }

    @Test
    public void testNonNumericCharacters() {
        StudyCalculator calculator = new StudyCalculator();
        assertThrows(RuntimeException.class, () -> calculator.sum("1 a"));
    }
}