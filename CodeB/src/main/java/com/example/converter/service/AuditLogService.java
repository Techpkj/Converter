package com.example.converter.service;

import com.example.converter.dto.ConversionRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditLogService {

    private final List<String> auditEntries = new ArrayList<>();

    public void logConversion(ConversionRequest request, String result) {
        String entry = String.format(
            "[%s] %s to %s: %s => %s",
            LocalDateTime.now(),
            request.getInputFormat(),
            request.getOutputFormat(),
            request.getInput(),
            result
        );
        auditEntries.add(entry);
        System.out.println(entry); // optional: log to stdout
    }

    public List<String> getAuditLog() {
        return auditEntries;
    }
}
