package ru.netology.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private static final int BALANCE = 1000;
    private static final int MONEY_100 = 100;
    private static final int MONEY_1100 = 1100;
    private final SavingsAccount SAVING_ACCOUNT = new SavingsAccount(BALANCE, "Сберегательный");


    @Test
    void testPaySuccess() {
        //expect
        assertThrows(Exception.class, ()->{
           SAVING_ACCOUNT.pay(MONEY_100);
        });
    }

    @Test
    void testAddMoneySuccess() throws  Exception{
        //given
        final int expected = 1100;
        //when
        int actual = SAVING_ACCOUNT.addMoney(MONEY_100);
        //then
        assertEquals(expected, actual);
    }

    @Test
    void testAddMoneyNotSuccess(){
        //given
        final int expected = 900;
        //when
        int actual = SAVING_ACCOUNT.addMoney(MONEY_1100);
        //then
        assertNotEquals(expected, actual);
    }
}
