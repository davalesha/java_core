package ru.netology;

public abstract class Account {
    protected int balance;
    protected String nameAccount;

    public Account(){
    }

    public Account(int balance, String nameAccount) {
        this.balance = balance;
        this.nameAccount = nameAccount;
    }

    public abstract int pay(int amount) throws Exception;

    public abstract int transfer(Account account, int amount) throws Exception;

    public abstract int addMoney(int amount) throws Exception;


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }
}
