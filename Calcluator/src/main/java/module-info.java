module hu.petrik.calcluator {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.petrik.calcluator to javafx.fxml;
    exports hu.petrik.calcluator;
}