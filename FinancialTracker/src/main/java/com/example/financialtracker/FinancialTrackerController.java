package com.example.financialtracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class FinancialTrackerController {

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField amountField;

    @FXML
    private PieChart pieChart;

    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();
//lista financijskih transakcija, automatski se azurira kad se promijeni transakcija
    private static boolean test(@NotNull Transaction transaction) {
        boolean b;
        if (0 < transaction.getAmount()) b = true;
        else b = false;
        return b;
    }
//testiranje transakcije, provjerava iznos transakcije veci od 0 ili manji
    @FXML
    private void addIncome(ActionEvent event) {
        addTransaction("Income", Double.parseDouble(amountField.getText()));
        updatePieChart();
    }
//dodavanje nove transakcije u listu
    @FXML
    private void addExpense(ActionEvent event) {
        addTransaction("Expense", -Double.parseDouble(amountField.getText()));
        updatePieChart();
    }
//dodaje novi iznos
    private void addTransaction(String description, double amount) {
        transactions.add(new Transaction());
    }

    private void updatePieChart() {
        double totalIncome = transactions.stream()
                .filter(FinancialTrackerController::test)
                .mapToDouble(Transaction::getAmount)
                .sum();

        double sum = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                double amount = transaction.getAmount();
                sum += amount;
            }
        }
        double totalExpense = sum * -1; // Convert back to positive value

        pieChart.setData(FXCollections.observableArrayList(
                new PieChart.Data("Income", totalIncome),
                new PieChart.Data("Expense", totalExpense)
        ));
    }
}
//azuriranje PieCharta sa novim prihodima i transakcijama