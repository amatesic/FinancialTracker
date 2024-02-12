import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart; //prikazivanje omjera ili udjela pojedinih dijelova u cjelini
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class FinancialTrackerController {

    @FXML //anotacijski marker označava polje, metodu ili kontroler
    private TextField descriptionField;

    @FXML
    private TextField amountField;

    @FXML
    private PieChart pieChart;

    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    @FXML
    private void addIncome(ActionEvent event) {
        addTransaction("Income", Double.parseDouble(amountField.getText()));
        updatePieChart();
    }

    @FXML
    private void addExpense(ActionEvent event) {
        addTransaction("Expense", -Double.parseDouble(amountField.getText()));
        updatePieChart();
    }

    private void addTransaction(String description, double amount) {
        transactions.add(new Transaction(description, amount, LocalDate.now()));
    }

    private void updatePieChart() {
        double totalIncome = transactions.stream()
                .filter(transaction -> transaction.getAmount() > 0)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double totalExpense = transactions.stream()
                .filter(transaction -> transaction.getAmount() < 0)
                .mapToDouble(Transaction::getAmount)
                .sum() * -1; // Convert back to positive value

        pieChart.setData(FXCollections.observableArrayList(
                new PieChart.Data("Income", totalIncome),
                new PieChart.Data("Expense", totalExpense)
        ));
    }
}
