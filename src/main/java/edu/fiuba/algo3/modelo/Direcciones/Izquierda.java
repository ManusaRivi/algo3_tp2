package edu.fiuba.algo3.modelo.Direcciones;

import edu.fiuba.algo3.modelo.Escenario.Posicion;

public class Izquierda implements Direccion {
    public void calcularPosicionSiguiente(Posicion pos){
        pos.restarX();
    }

    public Direccion opuesto(){
        return new Derecha();
    }
}