package bank.tech.test.java;

import java.util.ArrayList;

public class TransactionList implements ITransactionList {
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

    public double calculateBalance(int index) {
        double balance = 0;

        for (int i = 0; i <= index; i++) {
            if (transactions.get(i).getType() == TransactionType.CREDIT) {
                balance += transactions.get(i).getAmount();
            } else {
                balance -= transactions.get(i).getAmount();
            }
        }

        return balance;
    }
}
