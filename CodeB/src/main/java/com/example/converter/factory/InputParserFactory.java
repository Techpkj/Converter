package com.example.converter.factory;

import com.example.converter.enums.NumberFormat;
import com.example.converter.parser.BinaryParser;
import com.example.converter.parser.DecimalParser;
import com.example.converter.parser.InputParser;

import java.util.HashMap;
import java.util.Map;

public class InputParserFactory {

    private static final Map<NumberFormat, InputParser> parserMap = new HashMap<>();

    static {
        parserMap.put(NumberFormat.DECIMAL, new DecimalParser());
        parserMap.put(NumberFormat.BINARY, new BinaryParser());
    }

    public static InputParser getParser(NumberFormat format) {
        InputParser parser = parserMap.get(format);
        if (parser == null) {
            throw new IllegalArgumentException("Unsupported input format: " + format);
        }
        return parser;
    }
}
