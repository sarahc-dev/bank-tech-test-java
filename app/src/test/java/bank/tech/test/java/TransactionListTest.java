package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

public class TransactionListTest {
    @Test
    public void addsTransactionToTransactionList() {
        TransactionList transactionList = new TransactionList();
        MockTransaction mockTransaction = new MockTransaction();
        transactionList.add(mockTransaction);

        Assert.assertEquals(1, transactionList.getTransactions().size());
    }

    @Test
    public void addsMultipleTransactionsToTransactionList() {
        TransactionList transactionList = new TransactionList();
        MockTransaction mockTransaction1 = new MockTransaction();
        MockTransaction mockTransaction2 = new MockTransaction();
        MockTransaction mockTransaction3 = new MockTransaction();
        transactionList.add(mockTransaction1);
        transactionList.add(mockTransaction2);
        transactionList.add(mockTransaction3);

        Assert.assertEquals(3, transactionList.getTransactions().size());
    }

    private static class MockTransaction implements ITransaction {}
}


