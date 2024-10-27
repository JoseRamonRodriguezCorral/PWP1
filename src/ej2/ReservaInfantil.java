package ej2;

import java.util.Date;

public class ReservaInfantil extends Reserva {
    private int numNinos;

    public ReservaInfantil(String usuarioId, Date fechaHora, int duracion, String pistaId, double precio, double descuento, int numNinos) {
        super(usuarioId, fechaHora, duracion, pistaId, precio, descuento);
        this.numNinos = numNinos;
    }

    public int getNumNinos() { 
        return numNinos; 
    }

    public void setNumNinos(int numNinos) { 
        this.numNinos = numNinos; 
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Infantil, Número de Niños: " + numNinos;
    }
}
