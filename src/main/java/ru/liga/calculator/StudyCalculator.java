package ru.liga.calculator;

import com.google.common.base.Splitter;

public class StudyCalculator implements Calculator {
    private static final Integer ARGS_LENGTH = 2;

    @Override
    public int sum(String numbers, String delimiter) {
        Iterable<String> tokens;
        int count = 0;
        try {
            if (numbers.isEmpty()) {
                return 0;
            }
            if (hasDelimiterMarker(numbers)) {
                delimiter = defineDelimiter(numbers, delimiter);
                numbers = numbers.substring(3);
            }
            tokens = Splitter.on(delimiter).split(numbers);
            int result = 0;
            for (String token : tokens) {
                if (!hasDelimiterMarker(token.trim()) && numberIsPositive(token.trim())) {
                    count++;
                    if (count > ARGS_LENGTH) {
                        throw new RuntimeException("More than 2 numbers");
                    }
                    result += Integer.parseInt(token.trim());
                }
            }
            return result;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Calculation Exception! Details:", e);
        }
    }

    private String defineDelimiter(String numbers, String delimiter) {
        if (hasDelimiterMarker(numbers)) {
            delimiter = numbers.substring(2, 3);
        }
        return delimiter;
    }

    private boolean hasDelimiterMarker(String token) {
        return token.startsWith("//");
    }

    private boolean numberIsPositive(String token) {
        return !(token.trim().charAt(0) == '-');
    }

}
