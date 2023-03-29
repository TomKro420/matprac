module com.example.mp_tk {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mp_tk to javafx.fxml;
    exports com.example.mp_tk;
}