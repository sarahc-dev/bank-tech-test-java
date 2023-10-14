package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccountTest {
    @Test
    public void makesADeposit() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2023, 1, 10));
        ArrayList<ITransaction> transactions = bankAccount.getTransactionList().getTransactions();
        Assert.assertEquals(1000.0, transactions.get(0).getAmount(), 0.01);
        Assert.assertEquals(TransactionType.CREDIT, transactions.get(0).getType());
        Assert.assertEquals(LocalDate.of(2023, 1, 10), transactions.get(0).getDate());
    }

    @Test
    public void makesAWithdrawal() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(500, LocalDate.of(2023, 1, 10));
        ArrayList<ITransaction> transactions = bankAccount.getTransactionList().getTransactions();
        Assert.assertEquals(500.0, transactions.get(0).getAmount(), 0.01);
        Assert.assertEquals(TransactionType.DEBIT, transactions.get(0).getType());
        Assert.assertEquals(LocalDate.of(2023, 1, 10), transactions.get(0).getDate());
    }

    @Test
    public void depositReturnsErrorWhenAmountZero() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            BankAccount bankAccount = new BankAccount();
            bankAccount.deposit(0, LocalDate.of(2023, 1, 10));
        });
    }

    @Test
    public void depositReturnsErrorWhenAmountNegative() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            BankAccount bankAccount = new BankAccount();
            bankAccount.deposit(-100, LocalDate.of(2023, 1, 10));
        });
    }

    @Test
    public void withdrawReturnsErrorWhenAmountZero() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            BankAccount bankAccount = new BankAccount();
            bankAccount.withdraw(0, LocalDate.of(2023, 1, 10));
        });
    }

    @Test
    public void withdrawReturnsErrorWhenAmountNegative() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            BankAccount bankAccount = new BankAccount();
            bankAccount.withdraw(-100, LocalDate.of(2023, 1, 10));
        });
    }
}
