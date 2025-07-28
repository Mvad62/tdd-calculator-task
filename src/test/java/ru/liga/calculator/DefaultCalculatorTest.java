package ru.liga.calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class DefaultCalculatorTest {

        @Test
        public void testNullString() {
            StudyCalculator calculator = new StudyCalculator();
            assertThatThrownBy(() -> calculator.sum(null))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        public void testEmptyString() {
            StudyCalculator calculator = new StudyCalculator();
            assertThat(calculator.sum("")).isZero();
        }

        @Test
        public void testSingleNumber() {
            StudyCalculator calculator = new StudyCalculator();
            assertThat(calculator.sum("5")).isEqualTo(5);
        }

        @Test
        public void testTwoNumbers() {
            StudyCalculator calculator = new StudyCalculator();
            assertThat(calculator.sum("3 5")).isEqualTo(8);
        }

        @Test
        public void testMoreThanTwoNumbers() {
            StudyCalculator calculator = new StudyCalculator();
            assertThatThrownBy(() -> calculator.sum("1 2 3"))
                    .isInstanceOf(RuntimeException.class);
        }

    @Test
    public void testNonNumericCharacters() {
        StudyCalculator calculator = new StudyCalculator();
        //assertThrows(RuntimeException.class, () -> calculator.sum("1 a"));
        assertThatThrownBy(() -> calculator.sum("1 a"))
                .isInstanceOf(RuntimeException.class);
    }
}