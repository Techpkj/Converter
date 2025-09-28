package com.example.converter.service;

import com.example.converter.dto.ConversionRequest;
import com.example.converter.dto.ConversionResponse;
import com.example.converter.enums.NumberFormat;
import com.example.converter.factory.InputParserFactory;
import com.example.converter.factory.OutputFormatterFactory;
import com.example.converter.parser.InputParser;
import com.example.converter.formatter.OutputFormatter;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConversionService {

    private final List<String> auditLog = new ArrayList<>();

    public ConversionResponse convert(ConversionRequest request) {
        try {
            NumberFormat inputFormat = request.getInputFormat();
            NumberFormat outputFormat = request.getOutputFormat();

            InputParser parser = InputParserFactory.getParser(inputFormat);
            OutputFormatter formatter = OutputFormatterFactory.getFormatter(outputFormat);

            int number = parser.parse(request.getInput());
            String result = formatter.format(number);

            String auditEntry = String.format("%s: Converted '%s' from %s to %s = '%s'",
                    Instant.now(), request.getInput(), inputFormat, outputFormat, result);
            auditLog.add(auditEntry);
            System.out.println(auditEntry);

            return new ConversionResponse(result, "Success");
        } catch (Exception e) {
            String error = "Conversion failed: " + e.getMessage();
            System.err.println(error);
            return new ConversionResponse(null, error);
        }
    }

    public List<String> getAuditLog() {
        return auditLog;
    }
}
