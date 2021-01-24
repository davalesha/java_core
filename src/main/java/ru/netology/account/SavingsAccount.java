package ru.netology.account;

import ru.netology.Account;

public class SavingsAccount  extends Account {
    public SavingsAccount(int balance, String nameAccount) {
        super(balance, nameAccount);
    }


    @Override
    public int pay(int amount) throws Exception  {
        throw new Exception("Операция платежа по счету " + getNameAccount() + " запрещена");
    }

    @Override
    public int transfer(Account account, int amount) throws Exception {
        addMoney(amount);
        int pay = account.pay(amount);
        return pay;
    }

    @Override
    public int addMoney(int amount) {
        balance = balance + amount;
        return balance;
    }

}
