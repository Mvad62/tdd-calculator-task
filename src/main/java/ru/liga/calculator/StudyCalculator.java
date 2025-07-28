package ru.liga.calculator;

public class StudyCalculator implements Calculator {
    private static final Integer ARGS_LENGTH = 2;
    private static final String SEPARATOR = "\\s+";

    public int sum(String numbersString) {
        if (numbersString == null || numbersString.trim().isEmpty()) {
            return 0;
        }

        String[] numberParts = numbersString.split(SEPARATOR);

        if (numberParts.length > ARGS_LENGTH) {
            throw new RuntimeException("Больше двух чисел в строке аргумента");
        }

        int sum = 0;
        for (String number : numberParts) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Нечисловой символ в строке аргумента " + number);
            }
        }

        return sum;
    }
}