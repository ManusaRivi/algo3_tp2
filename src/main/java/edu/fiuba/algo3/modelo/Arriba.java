package edu.fiuba.algo3.modelo;

public class Arriba extends Direccion{
    public Posicion calcularPosicionSiguiente(Posicion pos){
        pos.sumarY();
        return pos;
    }

    public Direccion opuesto(){
        return new Abajo();
    }
}