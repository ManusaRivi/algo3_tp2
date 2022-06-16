package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Calle {

    boolean tieneObstaculo = false;
    boolean tieneSorpresa = false;

    private List<Interactuable> interactuables;
//    Obstaculo obstaculo;
//    Sorpresa sorpresa;

    public Calle() {
        interactuables = new ArrayList<>();
    }

    public void guardarInteractuable(Interactuable unInteractuable) {
        interactuables.add(unInteractuable);
    }

    public void guardarObstaculo(Obstaculo unObstaculo) {
        if(!tieneObstaculo){
            interactuables.add(unObstaculo);
            tieneObstaculo = true;
        }
    }

    public void guardarSorpresa(Sorpresa unaSorpresa) {
        if(!tieneObstaculo){
            interactuables.add(unaSorpresa);
            tieneSorpresa = true;
        }
    }

    public void atravesarCalle(Vehiculo vehiculo) {
        for(Interactuable i: interactuables){
            i.interactuarConVehiculo(vehiculo);
        }
    }
}