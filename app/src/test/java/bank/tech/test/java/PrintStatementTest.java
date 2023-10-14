package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class PrintStatementTest {
    @Test
    public void printStatementHeaderWhenNoTransactions() {
        MockEmptyTransactions mockEmptyTransactions = new MockEmptyTransactions();
        PrintStatement printStatement = new PrintStatement(mockEmptyTransactions);

        Assert.assertEquals("date || credit || debit || balance", printStatement.generate());
    }

    private static class MockEmptyTransactions implements ITransactionList {
        public void add(ITransaction transaction) {};

        @Override
        public ArrayList<ITransaction> getTransactions() {
            return new ArrayList<>();
        }
    }
}
