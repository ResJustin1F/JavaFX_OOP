module org.example.javafx_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafx_oop to javafx.fxml;
    exports org.example.javafx_oop;
}