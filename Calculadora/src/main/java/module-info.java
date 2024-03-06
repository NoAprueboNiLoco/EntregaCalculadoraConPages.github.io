module com.example.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;


    opens com.example.calculadora to javafx.fxml;
    exports com.example.calculadora;
}