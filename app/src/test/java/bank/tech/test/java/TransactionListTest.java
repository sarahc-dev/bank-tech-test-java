package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class TransactionListTest {
    @Test
    public void addsTransactionToTransactionList() {
        TransactionList transactionList = new TransactionList();
        MockCreditTransaction mockCreditTransaction = new MockCreditTransaction();
        transactionList.add(mockCreditTransaction);

        Assert.assertEquals(1, transactionList.getTransactions().size());
        Assert.assertEquals(100.0, transactionList.getTransactions().get(0).getAmount(), 0.01);
    }

    @Test
    public void addsMultipleTransactionsToTransactionList() {
        TransactionList transactionList = new TransactionList();
        MockCreditTransaction mockTransaction1 = new MockCreditTransaction();
        MockCreditTransaction mockTransaction2 = new MockCreditTransaction();
        MockCreditTransaction mockTransaction3 = new MockCreditTransaction();
        transactionList.add(mockTransaction1);
        transactionList.add(mockTransaction2);
        transactionList.add(mockTransaction3);

        Assert.assertEquals(3, transactionList.getTransactions().size());
        Assert.assertEquals(100.0, transactionList.getTransactions().get(2).getAmount(), 0.01);
    }

    @Test
    public void calculatesBalanceAfterOneTransaction() {
        TransactionList transactionList = new TransactionList();
        MockCreditTransaction mockTransaction = new MockCreditTransaction();
        transactionList.add(mockTransaction);

        Assert.assertEquals(100.0, transactionList.calculateBalance(0), 0.01);
    }

    @Test
    public void calculatesBalanceOfMultipleTransactions() {
        TransactionList transactionList = new TransactionList();
        MockCreditTransaction mockCreditTransaction = new MockCreditTransaction();
        MockDebitTransaction mockDebitTransaction = new MockDebitTransaction();
        transactionList.add(mockCreditTransaction);
        transactionList.add(mockDebitTransaction);
        transactionList.add(mockCreditTransaction);

        Assert.assertEquals(100.0, transactionList.calculateBalance(0), 0.01);
        Assert.assertEquals(50.0, transactionList.calculateBalance(1), 0.01);
        Assert.assertEquals(150.0, transactionList.calculateBalance(2), 0.01);
    }

    private static class MockCreditTransaction implements ITransaction {
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

    private static class MockDebitTransaction implements ITransaction {
        @Override
        public double getAmount() {
            return 50;
        }

        @Override
        public TransactionType getType() {
            return TransactionType.DEBIT;
        }

        @Override
        public LocalDate getDate() {
            return LocalDate.of(2023, 1,10);
        }
    }
}


