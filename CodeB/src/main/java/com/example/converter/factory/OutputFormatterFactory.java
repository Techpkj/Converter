package com.example.converter.factory;

import com.example.converter.enums.NumberFormat;
import com.example.converter.formatter.OutputFormatter;
import com.example.converter.formatter.RomanFormatter;

import java.util.HashMap;
import java.util.Map;

public class OutputFormatterFactory {

    private static final Map<NumberFormat, OutputFormatter> formatterMap = new HashMap<>();

    static {
        formatterMap.put(NumberFormat.ROMAN, new RomanFormatter());
    }

    public static OutputFormatter getFormatter(NumberFormat format) {
        OutputFormatter formatter = formatterMap.get(format);
        if (formatter == null) {
            throw new IllegalArgumentException("Unsupported output format: " + format);
        }
        return formatter;
    }
}
