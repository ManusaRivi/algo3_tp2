package edu.fiuba.algo3.modelo.Interactuables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class SorpresaFavorable extends Sorpresa{
    public void interactuarConVehiculo(Vehiculo vehiculo) {
        vehiculo.atravesarSorpresaFavorable();
    }
}