package bank.tech.test.java;

import java.util.ArrayList;

public interface ITransactionList {
    void add(ITransaction transaction);

    ArrayList<ITransaction> getTransactions();

    double calculateBalance(int index);
}
