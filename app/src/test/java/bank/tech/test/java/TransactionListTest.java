package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class TransactionListTest {
    @Test
    public void addsTransactionToTransactionList() {
        TransactionList transactionList = new TransactionList();
        MockTransaction mockTransaction = new MockTransaction();
        transactionList.add(mockTransaction);

        Assert.assertEquals(1, transactionList.getTransactions().size());
        Assert.assertEquals(100.0, transactionList.getTransactions().get(0).getAmount(), 0.01);
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
        Assert.assertEquals(100.0, transactionList.getTransactions().get(2).getAmount(), 0.01);
    }

    private static class MockTransaction implements ITransaction {
        @Override
        public double getAmount() {
            return 100;
        }

        @Override
        public TransactionType getType() {
            return TransactionType.CREDIT;
        }

        @Override
        public LocalDate getDate() {
            return LocalDate.of(2023, 1,10);
        }
    }
}


