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

public class cientificaController {
    @javafx.fxml.FXML
    private Button btn_Neg;
    @javafx.fxml.FXML
    private Label memoria;
    @javafx.fxml.FXML
    private Button btn_Resultado;
    @javafx.fxml.FXML
    private Button btn_6;
    @javafx.fxml.FXML
    private Button btn_5;
    @javafx.fxml.FXML
    private Button btn_4;
    @javafx.fxml.FXML
    private Button btn_Cos;
    @javafx.fxml.FXML
    private Button btn_3;
    @javafx.fxml.FXML
    private Button btn_9;
    @javafx.fxml.FXML
    private Button btn_8;
    @javafx.fxml.FXML
    private Button btn_7;
    @javafx.fxml.FXML
    private Button btn_Tan;
    @javafx.fxml.FXML
    private Button btn_Multiplicar;
    @javafx.fxml.FXML
    private Button btn_2;
    @javafx.fxml.FXML
    private Button btn_1;
    @javafx.fxml.FXML
    private Button btn_Sen;
    @javafx.fxml.FXML
    private Button btn_0;
    @javafx.fxml.FXML
    private Button btn_Sin;
    @javafx.fxml.FXML
    private Button btn_Dividir;
    @javafx.fxml.FXML
    private Button btn_Pos;
    @javafx.fxml.FXML
    private Button btn_Borrar;
    @javafx.fxml.FXML
    private Button btn_Restar;
    @javafx.fxml.FXML
    private Label calculo;
    @javafx.fxml.FXML
    private Button btn_Sumar;
    @javafx.fxml.FXML
    private Button btn_Decimal;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String numeroActual = "";
    private String simbolo = "";
    private double resultado = 0.0;

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

    @Deprecated
    public void onClick_Tiempo(ActionEvent actionEvent) {
    }


    @FXML
    public void onClick_Cos(ActionEvent actionEvent) {
        if (!numeroActual.isEmpty()) {
            double angle = Double.parseDouble(numeroActual);
            double result = Math.cos(Math.toRadians(angle));
            calculo.setText(String.valueOf(result));
            memoria.setText("cos(" + angle + ") = " + result);
            numeroActual = String.valueOf(result);
            simbolo = "";
        }
    }

    @FXML
    public void onClick_Sen(ActionEvent actionEvent) {
        if (!numeroActual.isEmpty()) {
            double angle = Double.parseDouble(numeroActual);
            double result = Math.sin(Math.toRadians(angle));
            calculo.setText(String.valueOf(result));
            memoria.setText("sin(" + angle + ") = " + result);
            numeroActual = String.valueOf(result);
            simbolo = "";
        }
    }

    @FXML
    public void onClick_Tan(ActionEvent actionEvent) {
        if (!numeroActual.isEmpty()) {
            double angle = Double.parseDouble(numeroActual);
            double result = Math.tan(Math.toRadians(angle));
            calculo.setText(String.valueOf(result));
            memoria.setText("tan(" + angle + ") = " + result);
            numeroActual = String.valueOf(result);
            simbolo = "";
        }
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
