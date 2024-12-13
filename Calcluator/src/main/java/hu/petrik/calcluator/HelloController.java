package hu.petrik.calcluator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    public TextField input1;
    public TextField input2;
    public Text output;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {
        input1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^-?\\d+(\\.\\d+)?$")) {
                    input1.setText(newValue.replaceAll("[^0-9.-]", ""));
                }
            }
        });

        input2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^-?\\d+(\\.\\d+)?$")) {
                    input2.setText(newValue.replaceAll("[^0-9.-]", ""));
                }
            }
        });
    }

    public void click(ActionEvent actionEvent) {
        try {
            double a = Double.parseDouble(input1.getText());
            double b = Double.parseDouble(input2.getText());
            Button button = (Button) actionEvent.getTarget();
            switch (button.getText()) {
                case "+":
                    output.setText(String.valueOf((a + b)));
                    break;
                case "-":
                    output.setText(String.valueOf((a - b)));
                    break;
                case "*":
                    output.setText(String.valueOf((a * b)));
                    break;
                case "/":
                    if (b == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Nullával nem lehet osztani!");
                        alert.show();
                    }
                    else output.setText(String.valueOf(Math.round((a / b) * 100.02) / 100.0));
                    break;
                case "%":
                    output.setText(String.valueOf((a % b)));
                    break;
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Hibás érték!");
            alert.show();
        }

    }
}