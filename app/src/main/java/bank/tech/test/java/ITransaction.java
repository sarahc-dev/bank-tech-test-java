package bank.tech.test.java;

import java.time.LocalDate;

public interface ITransaction {
    double getAmount();

    TransactionType getType();

    LocalDate getDate();
}
