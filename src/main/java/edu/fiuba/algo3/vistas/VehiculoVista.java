package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.VehiculoControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Observable;
import java.util.Observer;

public class VehiculoVista extends VBox implements Observer {
    private ImageView vehiculoView;
    private final Juego juego;
    private final VehiculoControlador controlador;
    private int posicionX;
    private int posicionY;

    public VehiculoVista(Juego juego, VehiculoControlador controlador){
        super();
        this.controlador = controlador;
        this.vehiculoView = new ImageView();
        this.juego = juego;
        this.vehiculoView = new ImageView(new Image(juego.getJugadorActual().obtenerVehiculo().getTipo().getUrlImagen()));

        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);

        this.getChildren().add(vehiculoView);
        this.setAlignment(Pos.CENTER);
    }
    @Override
    public void update(Observable unVehiculo, Object arg) {

        var vehiculo = (Vehiculo) unVehiculo;

        this.vehiculoView = new ImageView(new Image(vehiculo.getTipo().getUrlImagen()));
        this.vehiculoView.setFitWidth(50);
        this.vehiculoView.setFitHeight(50);
        this.getChildren().clear();
        this.getChildren().add(vehiculoView);

        this.posicionX = vehiculo.getPosicion().getPosicionX();
        this.posicionY = vehiculo.getPosicion().getPosicionY();

        if(vehiculo.estaEnLlegada()){
            this.controlador.terminarPartida();
        }
    }

    public int getPosicionX() {
        return this.posicionX;
    }

    public int getPosicionY() {
        return this.posicionY;
    }

}
