package ej2;

import java.util.Date;

public class ReservaFamiliar extends Reserva {
    private int numAdultos;
    private int numNinos;

    public ReservaFamiliar(String usuarioId, Date fechaHora, int duracion, String pistaId, double precio, double descuento, int numAdultos, int numNinos) {
        super(usuarioId, fechaHora, duracion, pistaId, precio, descuento);  // Llamada correcta al constructor de Reserva
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
    }

    public int getNumAdultos() { 
        return numAdultos; 
    }

    public void setNumAdultos(int numAdultos) { 
        this.numAdultos = numAdultos; 
    }

    public int getNumNinos() { 
        return numNinos; 
    }

    public void setNumNinos(int numNinos) { 
        this.numNinos = numNinos; 
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Familiar, Número de Adultos: " + numAdultos + ", Número de Niños: " + numNinos;
    }
}
