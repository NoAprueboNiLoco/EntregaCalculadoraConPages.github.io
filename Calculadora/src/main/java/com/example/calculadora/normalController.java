package com.example.calculadora;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class normalController {
    @FXML
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    @FXML
    private Button btn_Borrar, btn_Decimal,btn_Multiplicar, btn_Neg, btn_Pos, btn_Restar, btn_Resultado, btn_Sumar;
    @FXML
    private Label calculo, memoria;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String numeroActual = "";
    private String simbolo = "";
    private double resultado = 0.0;
    @FXML
    private Button btn_Dividir;

    @FXML
    void onClick_0(ActionEvent event) {
        numeroIngresado("0");
    }

    @FXML
    void onClick_1(ActionEvent event) {
        numeroIngresado("1");
    }

    @FXML
    void onClick_2(ActionEvent event) {
        numeroIngresado("2");
    }

    @FXML
    void onClick_3(ActionEvent event) {
        numeroIngresado("3");
    }

    @FXML
    void onClick_4(ActionEvent event) {
        numeroIngresado("4");
    }

    @FXML
    void onClick_5(ActionEvent event) {
        numeroIngresado("5");
    }

    @FXML
    void onClick_6(ActionEvent event) {
        numeroIngresado("6");
    }

    @FXML
    void onClick_7(ActionEvent event) {
        numeroIngresado("7");
    }

    @FXML
    void onClick_8(ActionEvent event) {
        numeroIngresado("8");
    }

    @FXML
    void onClick_9(ActionEvent event) {
        numeroIngresado("9");
    }

    @FXML
    void onClick_Decimal(ActionEvent event) {
        if (!numeroActual.contains(".")) {
            numeroActual += ".";
            calculo.setText(numeroActual);
        }
    }

    @FXML
    void onClick_Dividir(ActionEvent event) {
        calculo.setText(numeroActual);
        simboloIngresado("/");
        calculo.setText(calculo.getText() + " /");
    }

    @FXML
    void onClick_Multiplicar(ActionEvent event) {
        calculo.setText(numeroActual);
        simboloIngresado("*");
        calculo.setText(calculo.getText() + " *");
    }

    @FXML
    void onClick_Resta(ActionEvent event) {
        calculo.setText(numeroActual);
        simboloIngresado("-");
        calculo.setText(calculo.getText() + " -");
    }

    @FXML
    void onClick_Suma(ActionEvent event) {
        calculo.setText(numeroActual);
        simboloIngresado("+");
        calculo.setText(calculo.getText() + " +");
    }

    @FXML
    void onClick_Resultado(ActionEvent event) {
        if (!simbolo.isEmpty()) {
            double segundoOperador = Double.parseDouble(numeroActual);
            switch (simbolo) {
                case "+":
                    resultado += segundoOperador;
                    break;
                case "-":
                    resultado -= segundoOperador;
                    break;
                case "*":
                    resultado *= segundoOperador;
                    break;
                case "/":
                    if (segundoOperador != 0) {
                        resultado /= segundoOperador;
                    } else {
                        calculo.setText("Error: División por cero");
                        return;
                    }
                    break;
            }
            calculo.setText(Double.toString(resultado));
            memoria.setText(Double.toString(resultado));
            numeroActual = Double.toString(resultado);
            simbolo = "";
        }
    }

    @FXML
    void onClick_Borrar(ActionEvent event) {
        numeroActual = "";
        calculo.setText(numeroActual);
    }

    @FXML
    void onClick_Neg(ActionEvent event) {
        if (!numeroActual.isEmpty() && !numeroActual.equals("0")) {
            numeroActual = "-" + numeroActual;
            calculo.setText(numeroActual);
        }
    }

    @FXML
    void onClick_Pos(ActionEvent event) {
        if (!numeroActual.isEmpty() && numeroActual.startsWith("-")) {
            numeroActual = numeroActual.substring(1);
            calculo.setText(numeroActual);
        }
    }

    private void numeroIngresado(String number) {
        numeroActual += number;
        calculo.setText(numeroActual);
    }

    private void simboloIngresado(String op) {
        if (!numeroActual.isEmpty()) {
            simbolo = op;
            resultado = Double.parseDouble(numeroActual);
            numeroActual = "";
        }
    }

    @Deprecated
    void onClick_Calculadora(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("normal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClick_Cientifica(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cientifica.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClick_Normal(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("normal.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClick_Moneda(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("moneda.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void cerrar(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void onClick_Peso(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("peso.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClick_Longitud(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("longitud.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}