module org.example.rubikscubeb6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.rubikscubeb6 to javafx.fxml;
    exports org.example.rubikscubeb6;
}