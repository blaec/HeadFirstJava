package org.blaec.HeadFirstJava.threads;

public class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) {
        balance = balance - amount;
    }

    public int getBalance() {
        return balance;
    }
}
