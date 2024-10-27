package ej3;

import ej2.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ej1.Jugador;
public class GestorReservas {
    private List<Reserva> reservas;

    public GestorReservas() {
        reservas = new ArrayList<>();
    }

    // Hacer reserva individual
    public void hacerReservaIndividual(Reserva reserva, Jugador jugador) {
        if (esReservaValida(reserva, jugador)) {
            reservas.add(reserva);
            System.out.println("Reserva individual hecha con éxito.");
        } else {
            System.out.println("No se pudo hacer la reserva. Verifica las condiciones.");
        }
    }

    // Comprobar condiciones de reserva
    private boolean esReservaValida(Reserva reserva, Jugador jugador) {
        // Implementar la lógica para comprobar si la reserva es válida
        return true; // Cambiar según la lógica real
    }

    // Hacer reserva dentro de un bono
    public void hacerReservaBono(boolean bono, Reserva reserva) {
        // Implementar lógica para reservas de bonos
        System.out.println("Reserva realizada utilizando el bono.");
    }

    // Consultar reservas futuras
    public int consultarReservasFuturas() {
        Date hoy = new Date();
        int conteo = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getFechaHora().after(hoy)) {
                conteo++;
            }
        }
        return conteo;
    }
    

    // Consultar reservas para un día y una pista
    public List<Reserva> consultarReservasPorDiaYPista(Date fecha, String pistaId) {
        List<Reserva> reservasPorDia = new ArrayList<>();
        for (Reserva reserva : reservas) {
            if (reserva.getFechaHora().equals(fecha) && reserva.getPistaId().equals(pistaId)) {
                reservasPorDia.add(reserva);
            }
        }
        return reservasPorDia;
    }
}
