package ru.netology.account;

import ru.netology.Account;

public class CreditAccount extends Account {
    public CreditAccount(int balance, String nameAccount) {
        super(balance, nameAccount);
    }

    @Override
    public int pay(int amount) {
        balance = balance - amount;
        return balance;
    }

    @Override
    public int transfer(Account account, int amount) throws Exception {
        addMoney(amount);
        return account.pay(amount);
    }

    @Override
    public int addMoney(int amount) throws Exception {
        if ((balance + amount) < 0){
            balance = balance + amount;
        } else
            throw new Exception("Операция попоплнения счета " + getNameAccount() + " не возможна! ");

        return balance;
    }
}
