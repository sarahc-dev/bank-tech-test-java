package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class TransactionTest {
    @Test
    public void createDepositTransactionWithCorrectAttributes() {
        Transaction transaction = new Transaction(1000, TransactionType.CREDIT, LocalDate.of(2023, 1, 10));
        Assert.assertEquals(1000, transaction.getAmount(), 0.01);
        Assert.assertEquals(TransactionType.CREDIT, transaction.getType());
        Assert.assertEquals(LocalDate.of(2023, 1, 10), transaction.getDate());
    }

    @Test
    public void createWithdrawalTransactionWithCorrectAttributes() {
        Transaction transaction = new Transaction(500, TransactionType.DEBIT, LocalDate.of(2023, 1, 11));
        Assert.assertEquals(500, transaction.getAmount(), 0.01);
        Assert.assertEquals(TransactionType.DEBIT, transaction.getType());
        Assert.assertEquals(LocalDate.of(2023, 1, 11), transaction.getDate());
    }
}
