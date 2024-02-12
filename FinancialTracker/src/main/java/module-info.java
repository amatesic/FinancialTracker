module com.example.financialtracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires annotations;


    opens com.example.financialtracker to javafx.fxml;
    exports com.example.financialtracker;
}