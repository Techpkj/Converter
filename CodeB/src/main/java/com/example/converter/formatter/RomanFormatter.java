package com.example.converter.formatter;

public class RomanFormatter implements OutputFormatter {

    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] SYMBOLS = 
        {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override
    public String format(int number) {
        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Number must be between 1 and 3999 for Roman numerals.");
        }
        StringBuilder sb = new StringBuilder();
        int remainder = number;

        for (int i = 0; i < VALUES.length; i++) {
            while (remainder >= VALUES[i]) {
                sb.append(SYMBOLS[i]);
                remainder -= VALUES[i];
            }
        }
        return sb.toString();
    }
}
