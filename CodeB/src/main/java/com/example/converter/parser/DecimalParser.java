package com.example.converter.parser;

public class DecimalParser implements InputParser {

    @Override
    public int parse(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException("Decimal number cannot be negative");
            }
            return value;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid decimal number: " + input);
        }
    }
}
