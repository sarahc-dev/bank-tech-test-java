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
        Transaction newTransaction = new Transaction(amount, TransactionType.CREDIT, date);
        transactionList.add(newTransaction);
    }

    public void withdraw(double amount, LocalDate date) {
        Transaction newTransaction = new Transaction(amount, TransactionType.DEBIT, date);
        transactionList.add(newTransaction);
    }

//    public string generateStatement() {
//        Statement statement = new Statement(transactionList);
//        return statement.generateStatement();
//    }
}
