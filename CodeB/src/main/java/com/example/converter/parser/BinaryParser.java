package com.example.converter.parser;

public class BinaryParser implements InputParser {

    @Override
    public int parse(String input) {
        if (!input.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid binary number: " + input);
        }
        return Integer.parseInt(input, 2);
    }
}
