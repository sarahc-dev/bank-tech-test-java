package bank.tech.test.java;

import java.time.LocalDate;

public class BankAccount {
    private final ITransactionList transactionList;
    public BankAccount() {
        this.transactionList = new TransactionList();
    }
    public ITransactionList getTransactionList() {
        return transactionList;
    }

    public void deposit(double amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Transaction newTransaction = new Transaction(amount, TransactionType.CREDIT, date);
        transactionList.add(newTransaction);
    }

    public void withdraw(double amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Transaction newTransaction = new Transaction(amount, TransactionType.DEBIT, date);
        transactionList.add(newTransaction);
    }

    public String generateStatement() {
        PrintStatement statement = new PrintStatement(transactionList);
        return statement.generate();
    }
}
