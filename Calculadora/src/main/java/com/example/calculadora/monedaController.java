//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.calculadora;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class monedaController implements Initializable {


    private Stage stage;
    private Scene scene;
    private String primernumero = "";
    private String operador = "";
    private String numeroActual = "";
    private double res = 0.0;
    @FXML
    private ComboBox conversionInicial;
    @FXML
    private ComboBox conversionFinal;
    private final String[] codigosMonedas = new String[]{"USD", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SLL", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH", "UGX", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"};
    @FXML
    private Button btn_Borrar;
    @FXML
    private Label resultado;
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

    private Parent root;

    public void initialize(URL arg0, ResourceBundle arg1) {
        this.conversionFinal.setPromptText("conversion");
        this.conversionInicial.setPromptText("convertir");
        this.conversionFinal.getItems().addAll(this.codigosMonedas);
        this.conversionInicial.getItems().addAll(this.codigosMonedas);
    }

    @FXML
    public void clickDos(ActionEvent actionEvent) {
        this.addNumber("2");
    }

    @FXML
    public void clickNueve(ActionEvent actionEvent) {
        this.addNumber("9");
    }

    @FXML
    public void clickUno(ActionEvent actionEvent) {
        this.addNumber("1");
    }

    @FXML
    public void clickCuatro(ActionEvent actionEvent) {
        this.addNumber("4");
    }

    @FXML
    public void clickTres(ActionEvent actionEvent) {
        this.addNumber("3");
    }

    @FXML
    public void clickCinco(ActionEvent actionEvent) {
        this.addNumber("5");
    }

    @FXML
    public void clickCero(ActionEvent actionEvent) {
        this.addNumber("0");
    }

    @FXML
    public void clickSiete(ActionEvent actionEvent) {
        this.addNumber("7");
    }

    @FXML
    public void clickSeis(ActionEvent actionEvent) {
        this.addNumber("6");
    }

    @FXML
    public void clickOcho(ActionEvent actionEvent) {
        this.addNumber("8");
    }

    public void updateTextField() {
        this.resultado.setText("");
        this.resultado.setText(this.numeroActual);
    }

    public void addNumber(String num) {
        this.numeroActual = this.numeroActual + num;
        this.updateTextField();
    }

    @FXML
    public void clickBorrar(ActionEvent actionEvent) {
        this.numeroActual = "";
        this.resultado.setText("0");
        this.res = 0.0;
    }

    @Deprecated
    public void clickDecimal(ActionEvent actionEvent) {
        if (!this.numeroActual.contains(".")) {
            this.numeroActual = this.numeroActual + ".";
            this.resultado.setText(this.numeroActual);
        }

    }

    @FXML
    public void clickIgual(ActionEvent actionEvent) throws IOException {
        double quantity = Double.parseDouble(this.resultado.getText());
        String convertFrom = (String)this.conversionInicial.getValue();
        String convertTo = (String)this.conversionFinal.getValue();
        String urlString = "https://v6.exchangerate-api.com/v6/04bcb5398e4ac0ce7a6500d8/latest/" + convertFrom.toUpperCase();
        OkHttpClient client = new OkHttpClient();
        Request request = (new Request.Builder()).url(urlString).get().build();
        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONObject ratesObject = jsonObject.getJSONObject("conversion_rates");
        BigDecimal rate = ratesObject.getBigDecimal(convertTo.toUpperCase());
        BigDecimal result = rate.multiply(BigDecimal.valueOf(quantity));
        this.resultado.setText(String.valueOf(result));
    }

    @Deprecated
    public void clickBasica(ActionEvent actionEvent) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/Vista/calc.fxml"));
        this.stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    @Deprecated
    public void clickCientifica(ActionEvent actionEvent) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/Vista/calculadoraCientifica.fxml"));
        this.stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    /** @deprecated */
    @Deprecated
    public void clickConversion(ActionEvent actionEvent) throws IOException {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("/Vista/calculadoraConversion.fxml"));
        this.stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(this.scene);
        this.stage.show();
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
    public void onClick_Cientifica(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("normal.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onClick_Peso(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("normal.fxml")));
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
    public void onClick_Longitud(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("longitud.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
