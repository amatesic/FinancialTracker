import java.time.LocalDate;

public class Transaction {
    private final String description;
    private final double amount;
    private final LocalDate date;

    public Transaction(String description, double amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public static void add(Transaction transaction) {
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
