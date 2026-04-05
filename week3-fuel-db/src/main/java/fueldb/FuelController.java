package fueldb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.MessageFormat;

public class FuelController {

    @FXML private Label lblDistance;
    @FXML private Label lblConsumption;
    @FXML private Label lblPrice;
    @FXML private Label lblResult;
    @FXML private TextField txtDistance;
    @FXML private TextField txtConsumption;
    @FXML private TextField txtPrice;
    @FXML private Button btnCalculate;

    private LocalizationService locService = new LocalizationService();
    private CalculationService calcService = new CalculationService();
    private String currentLang = "en";

    @FXML
    public void initialize() {
        switchToLanguage("en");
    }

    private void switchToLanguage(String lang) {
        currentLang = lang;
        locService.loadStrings(lang);
        updateLabels();
    }

    private void updateLabels() {
        lblDistance.setText(locService.getString("distance.label"));
        lblConsumption.setText(locService.getString("consumption.label"));
        lblPrice.setText(locService.getString("price.label"));
        btnCalculate.setText(locService.getString("calculate.button"));
        lblResult.setText("");
    }

    @FXML
    private void handleCalculate() {
        try {
            double dist = Double.parseDouble(txtDistance.getText().trim());
            double cons = Double.parseDouble(txtConsumption.getText().trim());
            double price = Double.parseDouble(txtPrice.getText().trim());

            if (dist <= 0 || cons <= 0 || price <= 0) {
                lblResult.setText(locService.getString("invalid.input"));
                return;
            }

            double totalFuel = (cons / 100.0) * dist;
            double totalCost = totalFuel * price;

            String resultText = MessageFormat.format(
                    locService.getString("result.label"),
                    String.format("%.2f", totalFuel),
                    String.format("%.2f", totalCost)
            );
            lblResult.setText(resultText);

            CalculationRecord record = new CalculationRecord(dist, cons, price, totalFuel, totalCost, currentLang);
            calcService.saveCalculation(record);

        } catch (NumberFormatException e) {
            lblResult.setText(locService.getString("invalid.input"));
        }
    }

    @FXML
    private void switchEN() { switchToLanguage("en"); }

    @FXML
    private void switchFR() { switchToLanguage("fr"); }

    @FXML
    private void switchJP() { switchToLanguage("ja"); }

    @FXML
    private void switchIR() { switchToLanguage("fa"); }
}
