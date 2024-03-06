package com.example.calculadora;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class pesoController implements Initializable {


    @FXML
    private Button btn_Borrar;
    @FXML
    private Button btn_6;
    @FXML
    private Button btn_5;
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_3;
    @FXML
    private Button btn_9;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_7;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_0;
    private double factorConversion = 1.0;
    private String montoActual = "";
    @FXML
    private Label salidaUnidad;
    @FXML
    private Button btn_Onzas_in;
    @FXML
    private Label entradaUnidad;
    @FXML
    private Button btn_Libras_in;
    @FXML
    private Button btn_Gramos_in;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @Deprecated
    public void cerrar(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void onClick_Cientifica(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cientifica.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClick_Borrar(ActionEvent actionEvent) {
        if (!montoActual.isEmpty()) {
            montoActual = montoActual.substring(0, montoActual.length() - 1);
            salidaUnidad.setText(montoActual);
            actualizarConversion();
        }
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
    public void onClick_Normal(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("normal.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clickUno(ActionEvent actionEvent) {
        agregarNumero("1");
    }

    @FXML
    public void clickDos(ActionEvent actionEvent) {
        agregarNumero("2");
    }

    @FXML
    public void clickTres(ActionEvent actionEvent) {
        agregarNumero("3");
    }

    @FXML
    public void clickCuatro(ActionEvent actionEvent) {
        agregarNumero("4");
    }

    @FXML
    public void clickCinco(ActionEvent actionEvent) {
        agregarNumero("5");
    }

    @FXML
    public void clickSeis(ActionEvent actionEvent) {
        agregarNumero("6");
    }

    @FXML
    public void clickSiete(ActionEvent actionEvent) {
        agregarNumero("7");
    }

    @FXML
    public void clickOcho(ActionEvent actionEvent) {
        agregarNumero("8");
    }

    @FXML
    public void clickNueve(ActionEvent actionEvent) {
        agregarNumero("9");
    }

    @FXML
    public void clickCero(ActionEvent actionEvent) {
        agregarNumero("0");
    }

    private void agregarNumero(String numero) {
        montoActual += numero;
        entradaUnidad.setText(montoActual);
        actualizarConversion();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Establecer los factores de conversión al inicializar el controlador
        setFactorConversion(1000); // 1 kg = 1000 gramos
    }

    @FXML
    public void onClick_Onzas(ActionEvent actionEvent) {
        setFactorConversion(35.27396); // 1 kg = 35.27396 onzas
    }

    @FXML
    public void onClick_Libras(ActionEvent actionEvent) {
        setFactorConversion(2.204623); // 1 kg = 2.204623 libras
    }

    @FXML
    public void onClick_Gramos(ActionEvent actionEvent) {
        setFactorConversion(1); // 1 kg = 1000 gramos (ya establecido en initialize)
    }

    private void setFactorConversion(double factor) {
        factorConversion = factor;
        if (!montoActual.isEmpty()) {
            actualizarConversion();
        }
        actualizarConversion();
    }

    // Método para actualizar la conversión
    private void actualizarConversion() {
        try {
            double montoEntrada = Double.parseDouble(montoActual);
            double montoConvertido = montoEntrada * factorConversion;
            salidaUnidad.setText(String.valueOf(montoConvertido));
        } catch (NumberFormatException e) {
            salidaUnidad.setText("Error");
        }
    }

    // Método para manejar el clic en un botón numérico
    @Deprecated
    public void onClickNumero(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        montoActual += btn.getText();
        salidaUnidad.setText(montoActual);
        actualizarConversion();
    }

    // Método para manejar el clic en el botón de borrar


    @FXML
    public void onClick_Moneda(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("moneda.fxml")));
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