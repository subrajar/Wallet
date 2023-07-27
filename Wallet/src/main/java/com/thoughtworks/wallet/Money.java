package com.thoughtworks.wallet;

import Exceptions.NegativeAmountException;

public class Money {
    private final double value;
    private final Currency currency;

    public Money(double amount, Currency currency) throws Exception {
        if(amount<0)
            throw new NegativeAmountException();
        this.value = amount;
        this.currency = currency;
    }

    public Money add(Money money) throws Exception{
        return new Money(this.value + (money.value * money.currency.getConversionRate()),this.currency);
    }
    public Money remove(Money money) throws Exception {
        return new Money(this.value - (money.value * money.currency.getConversionRate()),this.currency);
    }

    public Money convertCurrency(Currency currency) throws Exception {
        return new Money(this.value/currency.getConversionRate(),currency);
    }



    @Override
    public boolean equals(Object object){

        if(object == null || object.getClass() != Money.class)
            return false;

        if(object == this)
            return true;

        Money money = (Money)object;

        return (money.value == this.value && money.currency == this.currency);

    }

    @Override
    public int hashCode() {
        return 12345;
    }


}
