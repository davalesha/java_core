package ru.netology.account;

import ru.netology.Account;

public class CheckingAccount extends Account {
    public CheckingAccount(int balance, String nameAccount) {
        super(balance, nameAccount);
    }

    @Override
    public int pay(int amount) throws Exception {
        if (balance > amount) {
            balance = balance - amount;
        } else {
            throw new Exception("Операция платежа со счета " + getNameAccount() + " не возможна. " +
                    "Сумма платежа превышает баланс");
        }
        return balance;
    }

    @Override
    public int transfer(Account account, int amount) throws Exception {
        addMoney(amount);
       return   account.pay(amount);
    }

    @Override
    public int addMoney(int amount) {
        return amount + balance;
    }
}
