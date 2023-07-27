package com.thoughtworks.wallet;

import Exceptions.InSufficientBalanceException;

public class Wallet {
    private Money balance;

    public Wallet() throws Exception{
        this.balance = new Money(0,Currency.RUPEE);
    }

    public void put(Money money) throws Exception{
        balance = balance.add(money);
    }

    public Money balance(Currency currency) throws Exception {
        return balance.convertCurrency(currency);
    }


    public void withdraw(Money money) throws InSufficientBalanceException {
        try {
            balance = balance.remove(money);
        }catch (Exception e){
            throw new InSufficientBalanceException();
        }
    }
}
