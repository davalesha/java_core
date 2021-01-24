package ru.netology.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {
    private static final int BALANCE = 1000;
    private static final int MONEY_100 = 100;
    private static final int MONEY_1100 = -1100;
    private final CreditAccount CREDIT_ACCOUNT = new CreditAccount(BALANCE, "Кредитный");

    @Test
    void testPaySuccess() {
        //given
        final int expected = 900;
        //when
        int actual = CREDIT_ACCOUNT.pay(MONEY_100);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void testPayNotSuccess() {
        //given
        final int expected = 1100;
        //when
        int actual = CREDIT_ACCOUNT.pay(MONEY_100);
        //then
        assertNotEquals(expected, actual);
    }

    @Test
    void testAddMoneySuccess() throws  Exception{
        //given
        final int expected = -100;
        //when
        int actual = CREDIT_ACCOUNT.addMoney(MONEY_1100);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void testAddMoneyNotSuccess(){
        //expect
        assertThrows(Exception.class, ()->{
            CREDIT_ACCOUNT.addMoney(MONEY_100);
        });
    }
}