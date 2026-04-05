package fuel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class FuelController {

    @FXML private Label lblDistance;
    @FXML private Label lblConsumption;
    @FXML private Label lblPrice;
    @FXML private Label lblResult;
    @FXML private TextField txtDistance;
    @FXML private TextField txtConsumption;
    @FXML private TextField txtPrice;
    @FXML private Button btnCalculate;

    private ResourceBundle bundle;

    @FXML
    public void initialize() {
        loadLanguage("en", "US");
    }

    private void loadLanguage(String lang, String country) {
        try {
            String name = "messages_" + lang + "_" + country + ".properties";
            var stream = getClass().getClassLoader().getResourceAsStream(name);
            if (stream != null) {
                bundle = new PropertyResourceBundle(new InputStreamReader(stream, StandardCharsets.UTF_8));
            } else {
                Locale locale = Locale.of(lang, country);
                bundle = ResourceBundle.getBundle("messages", locale);
            }
        } catch (IOException e) {
            Locale locale = Locale.of(lang, country);
            bundle = ResourceBundle.getBundle("messages", locale);
        }
        updateLabels();
    }

    private void updateLabels() {
        lblDistance.setText(bundle.getString("distance.label"));
        lblConsumption.setText(bundle.getString("consumption.label"));
        lblPrice.setText(bundle.getString("price.label"));
        btnCalculate.setText(bundle.getString("calculate.button"));
        lblResult.setText("");
    }

    @FXML
    private void handleCalculate() {
        try {
            double dist = Double.parseDouble(txtDistance.getText().trim());
            double cons = Double.parseDouble(txtConsumption.getText().trim());
            double price = Double.parseDouble(txtPrice.getText().trim());

            if (dist <= 0 || cons <= 0 || price <= 0) {
                lblResult.setText(bundle.getString("invalid.input"));
                return;
            }

            double totalFuel = (cons / 100.0) * dist;
            double totalCost = totalFuel * price;

            String result = MessageFormat.format(
                    bundle.getString("result.label"),
                    String.format("%.2f", totalFuel),
                    String.format("%.2f", totalCost)
            );
            lblResult.setText(result);

        } catch (NumberFormatException e) {
            lblResult.setText(bundle.getString("invalid.input"));
        }
    }

    @FXML
    private void switchEN() {
        loadLanguage("en", "US");
    }

    @FXML
    private void switchFR() {
        loadLanguage("fr", "FR");
    }

    @FXML
    private void switchJP() {
        loadLanguage("ja", "JP");
    }

    @FXML
    private void switchIR() {
        loadLanguage("fa", "IR");
    }
}
