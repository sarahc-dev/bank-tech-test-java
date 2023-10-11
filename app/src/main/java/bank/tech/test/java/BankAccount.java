package bank.tech.test.java;

import java.time.LocalDate;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(int amount, LocalDate date) {
        balance += amount;
    }
}
