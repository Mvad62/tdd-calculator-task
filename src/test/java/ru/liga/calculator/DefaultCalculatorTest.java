package ru.liga.calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class DefaultCalculatorTest {

        @Test
        public void testNullString() {
            StudyCalculator calculator = new StudyCalculator();
            assertThatThrownBy(() -> calculator.sum(null, "\\|"))
                    .isInstanceOf(RuntimeException.class);
        }

        @Test
        public void testEmptyString() {
            StudyCalculator calculator = new StudyCalculator();
            assertThat(calculator.sum("", "\\|")).isZero();
        }

        @Test
        public void testSingleNumber() {
            StudyCalculator calculator = new StudyCalculator();
            assertThat(calculator.sum("567890", "\\|")).isEqualTo(567890);
        }

        @Test
        public void testTwoNumbers() {
            StudyCalculator calculator = new StudyCalculator();
            assertThat(calculator.sum("//,10001,30003", "\\|")).isEqualTo(40004);
        }

        @Test
        public void testMoreThanTwoNumbers() {
            StudyCalculator calculator = new StudyCalculator();
            assertThatThrownBy(() -> calculator.sum("//,1,2,3", "\\|"))
                    .isInstanceOf(RuntimeException.class);
        }

    @Test
    public void testNonNumericCharacters() {
        StudyCalculator calculator = new StudyCalculator();
        assertThatThrownBy(() -> calculator.sum("1|a", "\\|"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void whenHasNegativeNumberIgnoreIt() {
        StudyCalculator calculator = new StudyCalculator();
        assertThat(calculator.sum("//*5*2*-5*-3", ","))
        .isEqualTo(7);
    }

}