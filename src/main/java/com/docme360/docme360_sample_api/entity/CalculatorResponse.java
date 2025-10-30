package com.docme360.docme360_sample_api.entity;

public class CalculatorResponse {
    private String input;
    private Double output;
    private String errorMessage;

    public CalculatorResponse(String input, Double output) {
        this.input = input;
        this.output = output;
    }

    public CalculatorResponse() {}

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Double getOutput() {
        return output;
    }

    public void setOutput(Double output) {
        this.output = output;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
