package ru.netology;

import ru.netology.account.CheckingAccount;
import ru.netology.account.CreditAccount;
import ru.netology.account.SavingsAccount;

public class Main {
    public static void main(String[] args) throws Exception {
        Account checkingAccount = new CheckingAccount(1000, "Рассчетный");
        Account creditAccount = new CreditAccount(0, "Kредитный");
        Account savingAccount = new SavingsAccount(500, "Сберегательный");

        showAccount(checkingAccount, creditAccount, savingAccount);

        savingAccount.addMoney(300);
        creditAccount.addMoney(200);
        checkingAccount.addMoney(100);

        showAccount(checkingAccount, creditAccount, savingAccount);

        savingAccount.pay(300);
        creditAccount.pay(600);
        checkingAccount.pay(200);

        showAccount(checkingAccount, creditAccount, savingAccount);

        savingAccount.transfer(checkingAccount, 400);

        showAccount(checkingAccount, creditAccount, savingAccount);

        creditAccount.transfer(checkingAccount, 600);
        showAccount(checkingAccount, creditAccount, savingAccount);
    }

    private static void showAccount(Account checking, Account credit, Account saving) {
        System.out.println("Сумма на Сберегательном счете : " + saving.getBalance());
        System.out.println("Сумма на Кредитном счете : " + credit.getBalance());
        System.out.println("Сумма на Расчетном счете : " + checking.getBalance());

    }
}
