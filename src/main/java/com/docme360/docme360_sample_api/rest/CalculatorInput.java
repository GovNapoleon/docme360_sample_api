package com.docme360.docme360_sample_api.rest;


public class CalculatorInput {
    private Double a;
    private Double b;

    public CalculatorInput() {}

    public CalculatorInput(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }
}