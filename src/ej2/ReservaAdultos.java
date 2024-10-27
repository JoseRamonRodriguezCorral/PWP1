package ej2;

import java.util.Date;

public class ReservaAdultos extends Reserva {
    private int numParticipantes;

    public ReservaAdultos(String usuarioId, Date fechaHora, int duracion, String pistaId, double precio, double descuento, int numParticipantes) {
        super(usuarioId, fechaHora, duracion, pistaId, precio, descuento);
        this.numParticipantes = numParticipantes;
    }

    public int getNumParticipantes() { 
        return numParticipantes; 
    }

    public void setNumParticipantes(int numParticipantes) { 
        this.numParticipantes = numParticipantes; 
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Adultos, Número de Participantes: " + numParticipantes;
    }
}
