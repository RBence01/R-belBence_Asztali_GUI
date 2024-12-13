package hu.petrik.masodfoku;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class HelloController {
    public Text output;
    public TextField x2;
    public TextField x1;
    public TextField x0;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {
        x2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^-?\\d+(\\.\\d+)?$")) {
                    x2.setText(newValue.replaceAll("[^0-9.-]", ""));
                }
            }
        });

        x1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^-?\\d+(\\.\\d+)?$")) {
                    x1.setText(newValue.replaceAll("[^0-9.-]", ""));
                }
            }
        });

        x0.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^-?\\d+(\\.\\d+)?$")) {
                    x0.setText(newValue.replaceAll("[^0-9.-]", ""));
                }
            }
        });
    }

    public void click(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        try {
            double a = Double.parseDouble(x2.getText());

            if (a == 0) {
                alert.setHeaderText("x^2 nem lehet 0!");
                alert.show();
                return;
            }
            double b = Double.parseDouble(x1.getText());
            double c = Double.parseDouble(x0.getText());

            double sqrt = Math.pow(b, 2) - 4*a*c;
            if (sqrt < 0) {
                alert.setHeaderText("Nem oldható meg a valós számok halmazán!");
                alert.show();
                return;
            }
            sqrt = Math.sqrt(sqrt);
            double res1 = (-b + sqrt) / 2*a;
            double res2 = (-b - sqrt) / 2*a;

            if (res1 == res2) {
                output.setText("x1 = x2 = " + res1);
            } else {
                output.setText(String.format("x1 = %.2f\nx2 = %.2f", res1, res2));
            }

        } catch (NumberFormatException e) {
            alert.setHeaderText("Hibás érték!");
            alert.show();
        }
    }

    public void keypress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            click(null);
        }
    }
}