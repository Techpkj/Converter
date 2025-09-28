package com.example.converter.dto;

import com.example.converter.enums.NumberFormat;

public class ConversionRequest {
    private String input;
    private NumberFormat inputFormat;
    private NumberFormat outputFormat;

    public ConversionRequest() {
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public NumberFormat getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(NumberFormat inputFormat) {
        this.inputFormat = inputFormat;
    }

    public NumberFormat getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(NumberFormat outputFormat) {
        this.outputFormat = outputFormat;
    }
}
