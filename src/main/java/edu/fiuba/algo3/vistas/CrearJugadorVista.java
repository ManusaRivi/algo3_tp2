package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.CrearJugadorControlador;
import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Escenario.Mapa;
import edu.fiuba.algo3.modelo.Escenario.TamanioMapa;
import edu.fiuba.algo3.modelo.Vehiculos.Tipo.*;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CrearJugadorVista extends BorderPane {

    private Mapa mapa;
    private Tipo vehiculo;

    public CrearJugadorVista() {
        var controlador = new CrearJugadorControlador();

        Label lblNombre = new Label("Nombre: ");
        lblNombre.setStyle("-fx-text-fill: black;" +
                "-fx-font-size: 12pt;"
        );
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Ingrese un nombre");
        txtNombre.setMinWidth(70);

        HBox nombreJugador = new HBox();
        nombreJugador.getChildren().add(lblNombre);
        nombreJugador.getChildren().add(txtNombre);
        nombreJugador.setPadding(new Insets(0, 0, 0, 5));

        // Botones vehiculo
        ToggleGroup tg1 = new ToggleGroup();
        HBox vehiculos = new HBox();

        Label elegirVehiculo = new Label("Elegí tu vehículo: ");
        RadioButton auto = new RadioButton("Auto");
        RadioButton moto = new RadioButton("Moto");
        RadioButton camioneta = new RadioButton("Camioneta");

        auto.setToggleGroup(tg1);
        moto.setToggleGroup(tg1);
        camioneta.setToggleGroup(tg1);

        vehiculos.getChildren().addAll(elegirVehiculo, auto, moto, camioneta);

        // Botones Mapa
        ToggleGroup tg2 = new ToggleGroup();
        HBox mapas = new HBox();

        Label elegirMapa = new Label("Elegí el tamaño del mapa: ");
        RadioButton chico = new RadioButton("Chico");
        RadioButton mediano = new RadioButton("Mediano");
        RadioButton grande = new RadioButton("Grande");

        chico.setToggleGroup(tg2);
        mediano.setToggleGroup(tg2);
        grande.setToggleGroup(tg2);

        mapas.getChildren().addAll(elegirMapa, chico, mediano, grande);

        tg1.selectedToggleProperty().addListener(
                (observable) -> {
                    RadioButton rb = (RadioButton)tg1.getSelectedToggle();
                    switch(rb.getText()){
                        case "Auto":
                            this.vehiculo = new Auto();
                            break;
                        case "Moto":
                            this.vehiculo = new Moto();
                            break;
                        case "Camioneta":
                            this.vehiculo = new Camioneta();
                            break;
                    }
                }
        );

        tg2.selectedToggleProperty().addListener(
                (observable) -> {
                    RadioButton rb = (RadioButton)tg2.getSelectedToggle();
                    switch(rb.getText()){
                        case "Chico":
                            this.mapa = new Mapa(TamanioMapa.CHICO, new Aleatorio());
                            break;
                        case "Mediano":
                            this.mapa = new Mapa(TamanioMapa.MEDIANO, new Aleatorio());
                            break;
                        case "Grande":
                            this.mapa = new Mapa(TamanioMapa.GRANDE, new Aleatorio());
                            break;
                    }
                }
        );

        HBox iniciar = new HBox();
        iniciar.setSpacing(10);
        Button btnIniciar = new Button("Iniciar partida!");
        btnIniciar.setOnMouseClicked((evento) -> controlador.iniciarPartida(txtNombre.getText(), this.vehiculo, this.mapa));
        btnIniciar.setStyle("-fx-background-radius: 90;");
        iniciar.getChildren().add(btnIniciar);
        iniciar.setPadding(new Insets(0, 0, 0, 80));

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(nombreJugador, vehiculos, mapas, iniciar);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setPadding(new Insets(85, 0, 0, 60));

        this.setTop(vBox);
    }
}