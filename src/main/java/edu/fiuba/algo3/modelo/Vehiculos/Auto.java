package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Aleatorio;
import edu.fiuba.algo3.modelo.Direcciones.Direccion;
import edu.fiuba.algo3.modelo.Escenario.Mapa;

import java.util.Random;

public class Auto implements Tipo {

    public int atravesarPozo(){
        return 3;
    }

    public int atravesarPiquete(Mapa mapa, Direccion direccion, Vehiculo vehiculo) {
        mapa.moverVehiculo(vehiculo, direccion.opuesto());
        return -1;
    }

    public int atravesarControlPolicial() {
        Aleatorio random = new Aleatorio();
        if(random.atravesarControlPolicial(0.5F)) return 3;
        return 0;
    }

    public Tipo atravesarCambioVehiculo() {
        return new Camioneta();
    }

}
