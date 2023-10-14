package bank.tech.test.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PrintStatement {
    private final ITransactionList transactionList;

    public PrintStatement(ITransactionList transactionList) {
        this.transactionList = transactionList;
    }

    public String generate() {
        StringBuilder statement = new StringBuilder(generateHeader());
        ArrayList<ITransaction> transactions = transactionList.getTransactions();

        // Prints transactions in reverse
        for (int i = transactions.size() - 1; i >= 0; i--) {
            statement.append(generateTransactionRow(transactions.get(i), i));
        }
        return statement.toString();
    }

    private String generateHeader() {
        return "date || credit || debit || balance\n";
    }

    private String generateTransactionRow(ITransaction transaction, int index) {
        if (transaction.getType() == TransactionType.CREDIT) {
            return formatDate(transaction.getDate()) + " || " + formatCurrency(transaction.getAmount()) + " || - || " + formatCurrency(transactionList.calculateBalance(index)) + "\n";
        } else {
            return formatDate(transaction.getDate()) + " || - || " + formatCurrency(transaction.getAmount()) + " || " + formatCurrency(transactionList.calculateBalance(index)) + "\n";
        }
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private String formatCurrency(double value) {
        return String.format("%.2f", value);
    }
}
