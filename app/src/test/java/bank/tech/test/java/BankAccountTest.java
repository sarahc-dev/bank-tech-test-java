package bank.tech.test.java;

import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class BankAccountTest {
    @Test
    public void makesADepositToBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2023, 1, 10));
        Assert.assertEquals(1000.00, bankAccount.getBalance(), 0.01);
    }

    @Test
    public void makesAWithdrawalFromBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(1000, LocalDate.of(2023, 1, 10));
        Assert.assertEquals(-1000.00, bankAccount.getBalance(), 0.01);
    }
}
