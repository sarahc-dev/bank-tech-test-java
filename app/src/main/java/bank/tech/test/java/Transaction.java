package bank.tech.test.java;

import java.time.LocalDate;

public class Transaction implements ITransaction {
    private final double amount;
    private final TransactionType type;
    private final LocalDate date;

    public Transaction(double amount, TransactionType type, LocalDate date) {
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }
}

