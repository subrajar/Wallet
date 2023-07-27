package com.thoughtworks.wallet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class WalletTest {
    @Nested
    class RupeeTest {
        @Test
        void shouldReturnInitialBalanceAsZeroRupees() throws Exception {
            Wallet wallet = new Wallet();
            Money expected = new Money(0, Currency.RUPEE);

            Money actual = wallet.balance(Currency.RUPEE);

            assertThat(actual, is(equalTo(expected)));

        }

        @Test
        void shouldReturnMoneyInRupeesWhenTwentyDollarToWalletAdded() throws Exception {
            double amount = 20;
            Money expected = new Money(amount*80, Currency.RUPEE);
            Money money = new Money(amount,Currency.DOLLAR);
            Wallet wallet = new Wallet();
            wallet.put(expected);

            Money actual = wallet.balance(Currency.RUPEE);

            assertThat(actual, is(equalTo(expected)));
        }

        @Test
        void shouldAddRupeeToWallet() throws Exception {
            double amount1 = 20;
            double amount2 = 10.5;
            Money money1 = new Money(amount1,Currency.RUPEE);
            Money money2 = new Money(amount2,Currency.RUPEE);
            Wallet wallet = new Wallet();
            Money expected = new Money(30.5,Currency.RUPEE);
            wallet.put(money1);
            wallet.put(money2);

            Money actual = wallet.balance(Currency.RUPEE);

            assertThat(actual, is(equalTo(expected)));
        }

        @Test
        void shouldBeAbleToWithdrawRupeeFromWallet() throws Exception {
            Money expected = new Money(20,Currency.RUPEE);
            Money money1 = new Money(1, Currency.DOLLAR);
            Money money2 = new Money(60, Currency.RUPEE);
            Wallet wallet = new Wallet();
            wallet.put(money1);
            wallet.withdraw(money2);

            Money actual = wallet.balance(Currency.RUPEE);

            assertThat(actual, is(equalTo(expected)));
        }
    }
    @Nested
    class DollarTest{
        @Test
        void shouldReturnInitialBalanceAsZeroDollar() throws Exception {
            Wallet wallet = new Wallet();
            Money expected = new Money(0, Currency.DOLLAR);

            Money actual = wallet.balance(Currency.DOLLAR);

            assertThat(actual, is(equalTo(expected)));

        }
        @Test
        void shouldAddTwentyDollarToWallet() throws Exception {
            double amount = 20;
            Money expected = new Money(amount, Currency.DOLLAR);
            Money money = new Money(amount, Currency.DOLLAR);
            Wallet wallet = new Wallet();
            wallet.put(money);

            Money actual = wallet.balance(Currency.DOLLAR);

            assertThat(actual, is(equalTo(expected)));
        }
        @Test
        void shouldReturnBalanceInDollarWhenRupeeAndDollarAdded() throws Exception {
            Money expected = new Money(11, Currency.DOLLAR);
            Money money1 = new Money(10, Currency.DOLLAR);
            Money money2 = new Money(80,Currency.RUPEE);
            Wallet wallet = new Wallet();
            wallet.put(money1);
            wallet.put(money2);

            Money actual = wallet.balance(Currency.DOLLAR);

            assertThat(actual, is(equalTo(expected)));
        }
        @Test
        void shouldBeAbleToWithdrawDollarFromWallet() throws Exception {
            Money expected = new Money(9,Currency.DOLLAR);
            Money money1 = new Money(800, Currency.RUPEE);
            Money money2 = new Money(1, Currency.DOLLAR);
            Wallet wallet = new Wallet();
            wallet.put(money1);
            wallet.withdraw(money2);

            Money actual = wallet.balance(Currency.DOLLAR);

            assertThat(actual, is(equalTo(expected)));
        }
    }
}
