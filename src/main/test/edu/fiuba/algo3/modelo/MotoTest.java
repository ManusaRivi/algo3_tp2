package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    @Test
    public void motoRecienCreadaTieneCeroMovimientos() {
        Vehiculo moto = new Moto();
        assertEquals(0, moto.getMovimientos());
    }

    }
