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

    private static class MockTransaction implements ITransaction {}
}


