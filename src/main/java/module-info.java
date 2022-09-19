module com.example.kp_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires itextpdf;


    opens com.example.kp_db to javafx.fxml;
    exports com.example.kp_db;
    exports com.example.kp_db.Class;
    opens com.example.kp_db.Class to javafx.fxml;
}