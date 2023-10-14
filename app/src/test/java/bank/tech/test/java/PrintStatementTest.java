package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class PrintStatementTest {
    @Test
    public void printStatementWithNoTransactions() {
        MockEmptyTransactions mockEmptyTransactions = new MockEmptyTransactions();
        PrintStatement printStatement = new PrintStatement(mockEmptyTransactions);

        Assert.assertEquals("date || credit || debit || balance\n", printStatement.generate());
    }

    @Test
    // Using Mockito
    public void printStatementWithTransactions() {
        ITransaction transaction1 = mock(ITransaction.class);
        when(transaction1.getAmount()).thenReturn(100.0);
        when(transaction1.getType()).thenReturn(TransactionType.CREDIT);
        when(transaction1.getDate()).thenReturn(LocalDate.of(2023, 1, 10));

        ITransaction transaction2 = mock(ITransaction.class);
        when(transaction2.getAmount()).thenReturn(50.0);
        when(transaction2.getType()).thenReturn(TransactionType.DEBIT);
        when(transaction2.getDate()).thenReturn(LocalDate.of(2023, 1, 11));

        ITransaction transaction3 = mock(ITransaction.class);
        when(transaction3.getAmount()).thenReturn(150.0);
        when(transaction3.getType()).thenReturn(TransactionType.CREDIT);
        when(transaction3.getDate()).thenReturn(LocalDate.of(2023, 1, 11));

        ITransactionList mockTransactionList = mock(ITransactionList.class);
        ArrayList<ITransaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        when(mockTransactionList.getTransactions()).thenReturn(transactions);
        // Return 0 - not testing balance logic here
        when(mockTransactionList.calculateBalance(anyInt())).thenReturn(0.00);

        PrintStatement printStatement = new PrintStatement(mockTransactionList);

        String expectedStatement = "date || credit || debit || balance\n11/01/2023 || 150.00 || - || 0.00\n11/01/2023 || - || 50.00 || 0.00\n10/01/2023 || 100.00 || - || 0.00\n";
        Assert.assertEquals(expectedStatement, printStatement.generate());
    }

    private static class MockEmptyTransactions implements ITransactionList {
        public void add(ITransaction transaction) {};

        @Override
        public ArrayList<ITransaction> getTransactions() {
            return new ArrayList<>();
        }

        @Override
        public double calculateBalance(int index) {
            return 0;
        };
    }
}
