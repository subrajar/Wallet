package com.thoughtworks.wallet;

public enum Currency {
    RUPEE(1),
    DOLLAR(80);

    private double conversionRate;

    Currency(double conversionRate) {
        this.conversionRate = conversionRate;
    }
    public double getConversionRate(){
        return this.conversionRate;
    }
}
