# Bank Tech Test - Java

## Built with

- Java
- JUnit
- Gradle

## The task

Your task is to write an application that a user can call to make bank transactions and then print a bank statement to the terminal.

Here are the requirements:

- Implement deposits and withdrawals.
- Implement an account statement that prints a heading row, and the date, amount and balance of each transaction, most recent first.
- You don't need to implement a command-line or user interface, test-driving and calling it in your main method.
- Data can be kept in memory, doesn't need to be in a database.
- Below is an example of how your code should be called, and what it should output.

```java
package bank;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        // Given a client makes a deposit of 1000 on 2021-01-10
        bankAccount.deposit(1000, LocalDate.of(2023, 1, 10));

        // And a deposit of 2000 on 2021-01-13
        bankAccount.deposit(2000, LocalDate.of(2023, 1, 13));

        // And a withdrawal of 500 on 2021-01-14
        bankAccount.withdraw(500, LocalDate.of(2023, 1, 14));

        // When she prints her bank statement
        System.out.println(bankAccount.generateStatement());
    }
}
```

## Acceptance Criteria

**Given** a client makes a deposit of 1000 on 10-01-2023
**And** a deposit of 2000 on 13-01-2023
**And** a withdrawal of 500 on 14-01-2023
**When** she prints her bank statement
**Then** she would see

```plain
date || credit || debit || balance
14/01/2023 || || 500.00 || 2500.00
13/01/2023 || 2000.00 || || 3000.00
10/01/2023 || 1000.00 || || 1000.00
```

## Process

I initially created the BankAccount class with deposit and withdrawal functionality. I then considered how I was going to 
proceed in 'saving' the transactions.

I have chosen to create separate TransactionList and PrintStatement classes. A class should do one thing, and therefore
it should only have a single reason to change. So following the single responsibility principle, I am separating the
persistence logic (here I am keeping the data in memory, but this could in future deal with a database). I am also
separating the printing logic that deals with formatting the bank statement. This way, in the future if I want to change
where data is saved or how it is printed, I only need to change the one class.

I also realised that in Java I can't simply create a 'transaction' object with multiple keys and value types to add to 
an array as I may have in JavaScript. So I am going to create a Transaction class as well to assign these attributes. I 
like that I am almost guided to this decision by the constructs of the language.
