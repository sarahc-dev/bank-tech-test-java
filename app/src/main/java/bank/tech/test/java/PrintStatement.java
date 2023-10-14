package bank.tech.test.java;

public class PrintStatement {
    private final ITransactionList transactionList;

    public PrintStatement(ITransactionList transactionList) {
        this.transactionList = transactionList;
    }

    public String generate() {
        return generateHeader();
    }

    private String generateHeader() {
        return "date || credit || debit || balance";
    }
}
