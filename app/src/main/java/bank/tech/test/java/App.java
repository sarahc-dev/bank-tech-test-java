/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bank.tech.test.java;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2023, 1, 10));
        ArrayList<ITransaction> newTransactions = bankAccount.getTransactionList().getTransactions();
        System.out.println(newTransactions.get(0).getAmount());
    }
}
