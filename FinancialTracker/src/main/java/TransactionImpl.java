import java.time.LocalDate;

public class TransactionImpl extends Transaction {
    public TransactionImpl(String description, double amount, LocalDate date) {
        super(description, amount, date);
    }
}
