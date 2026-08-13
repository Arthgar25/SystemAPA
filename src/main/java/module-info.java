module com.example.systemapa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.systemapa to javafx.fxml;
    exports com.example.systemapa;
}