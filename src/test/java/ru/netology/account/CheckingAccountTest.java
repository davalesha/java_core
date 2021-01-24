package ru.netology.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.account.CheckingAccount;

import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest {
    private static final int BALANCE = 1000;
    private static final int MONEY_100 = 100;
    private static final int MONEY_1100 = 1100;
    private final CheckingAccount CHECKING_ACCOUNT = new CheckingAccount(BALANCE, "Расчетный");

    @Test
    public void testAddMoneySuccess() {
        //given подготавливаем данные
        final int expected = 1100; // ожидается
        //when вызываем целевой метод
        int actual = CHECKING_ACCOUNT.addMoney(MONEY_100);
        //then производим проверку(сравниваем ожидание и результат)
        assertEquals(expected, actual);
    }

    @Test
    public void testAddMoneyNotSuccess() {
        //given
        final int expected = 1300;
        //when
        int actual = CHECKING_ACCOUNT.addMoney(MONEY_100);
        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void testPaySuccess() throws Exception {
        //given
        final int expected = 900;
        //when
        int actual = CHECKING_ACCOUNT.pay(MONEY_100);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void testPayNotSuccess() {
        //expect
        assertThrows(Exception.class, ()->{
            CHECKING_ACCOUNT.pay(MONEY_1100);
        });
    }
}
