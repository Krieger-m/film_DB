module com.krieger.a_2_filmdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.krieger.a_2_filmdb to javafx.fxml;
    exports com.krieger.a_2_filmdb;
}