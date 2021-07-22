package com.jitterted.ebp.blackjack;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

    @Test
    void testNewWalletIsEmpty() {
        Wallet wallet = new Wallet();
        boolean isEmpty = wallet.isEmpty();
        assertThat(isEmpty).isTrue();
    }

    @Test
    void testAddMoneyThenWalletIsNotEmpty() {
        Wallet wallet = new Wallet();
        wallet.addMoney(1);
        assertThat(wallet.isEmpty()).isFalse();
    }

    @Test
    void testNewWalletHasAZeroBalance() {
        Wallet wallet = new Wallet();
        int result = wallet.getBalance();
        assertThat(result).isZero();
    }

    @Test
    void testNewWalletAdd15HasABalanceOf15() {
        Wallet wallet = new Wallet();
        wallet.addMoney(15);
        int result = wallet.getBalance();
        assertThat(result).isEqualTo(15);

    }

    @Test
    void testNewWalletAdd15Then18HasBalanceOf33() {
        Wallet wallet = new Wallet();
        wallet.addMoney(15);
        wallet.addMoney(18);
        int result = wallet.getBalance();
        assertThat(result).isEqualTo(15 + 18);
    }

    @Test
    void testThatWeCannotPutNegativeIntoAddMoney() {
        Wallet wallet = new Wallet();
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                wallet.addMoney(-40);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testBetting10ReducesWalletBalanceBy10() {
        Wallet wallet = new Wallet();
        wallet.addMoney(15);
        wallet.bet(10);
        int result = wallet.getBalance();
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testBettingMultipleTimesReducesBalance() {
        Wallet wallet = new Wallet();
        wallet.addMoney(15);
        wallet.bet(5);
        wallet.bet(5);
        int result = wallet.getBalance();
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testBettingWholeWalletAmountEmptiesWallet() {
        Wallet wallet = new Wallet();
        wallet.addMoney(15);
        wallet.bet(10);
        wallet.bet(5);
        assertThat(wallet.isEmpty()).isTrue();
    }

    @Test
    void testCannotBetMoreThanWeHave() {
        Wallet wallet = new Wallet();
        wallet.addMoney(15);
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                wallet.bet(20);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
