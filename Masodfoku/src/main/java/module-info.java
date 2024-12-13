module hu.petrik.masodfoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.petrik.masodfoku to javafx.fxml;
    exports hu.petrik.masodfoku;
}