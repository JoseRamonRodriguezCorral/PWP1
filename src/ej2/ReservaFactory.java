package ej2;

import java.util.Date;

public class ReservaFactory {

    /**
     * Crea una nueva reserva según el tipo especificado.
     *
     * @param tipo       El tipo de reserva ("infantil", "familiar", "adultos").
     * @param usuarioId  El ID del usuario que realiza la reserva.
     * @param fechaHora  La fecha y hora de la reserva.
     * @param duracion   La duración de la reserva en minutos.
     * @param pistaId    El ID de la pista.
     * @param precio     El precio de la reserva.
     * @param descuento  El descuento aplicable a la reserva.
     * @param numAdultos Número de adultos para reservas familiares/adultos.
     * @param numNinos   Número de niños para reservas infantiles/familiares.
     * @return La reserva creada.
     */
    public static Reserva crearReserva(String tipo, String usuarioId, Date fechaHora, int duracion, String pistaId, double precio, double descuento, int numAdultos, int numNinos) {
        switch (tipo.toLowerCase()) {
            case "infantil":
                return new ReservaInfantil(usuarioId, fechaHora, duracion, pistaId, precio, descuento, numNinos);

            case "familiar":
                return new ReservaFamiliar(usuarioId, fechaHora, duracion, pistaId, precio, descuento, numAdultos, numNinos);

            case "adultos":
                return new ReservaAdultos(usuarioId, fechaHora, duracion, pistaId, precio, descuento, numAdultos);

            default:
                throw new IllegalArgumentException("Tipo de reserva no válido.");
        }
    }

    /**
     * Crea una nueva reserva utilizando un bono.
     *
     * @param tipo        El tipo de reserva ("infantil", "familiar", "adultos").
     * @param usuarioId   El ID del usuario que realiza la reserva.
     * @param fechaHora   La fecha y hora de la reserva.
     * @param duracion    La duración de la reserva en minutos.
     * @param pistaId     El ID de la pista.
     * @param precio      El precio de la reserva.
     * @param descuento   El descuento aplicable a la reserva.
     * @param numAdultos  Número de adultos para reservas familiares/adultos.
     * @param numNinos    Número de niños para reservas infantiles/familiares.
     * @param numeroSesion Número de sesión del bono.
     * @param bonoId      ID del bono utilizado.
     * @return La reserva creada.
     */
    public static Reserva crearReservaBono(String tipo, String usuarioId, Date fechaHora, int duracion, String pistaId, double precio, double descuento, int numAdultos, int numNinos, int numeroSesion, int bonoId) {
        // Aquí podrías añadir lógica para el uso de bonos, si es necesario.
        return crearReserva(tipo, usuarioId, fechaHora, duracion, pistaId, precio, descuento, numAdultos, numNinos);
    }
}
