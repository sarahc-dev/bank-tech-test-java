package bank.tech.test.java;

import java.util.ArrayList;

public class TransactionList {
    private final ArrayList<ITransaction> transactions;

    public TransactionList() {
        this.transactions = new ArrayList<>();
    }

    public void add(ITransaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<ITransaction> getTransactions() {
        return transactions;
    }
}