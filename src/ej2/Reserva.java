package ej2;

import java.util.Date;

public class Reserva {
    private String usuarioId;
    private Date fechaHora;
    private int duracion;
    private String pistaId;
    private double precio;
    private double descuento;

    public Reserva() {}

    public Reserva(String usuarioId, Date fechaHora, int duracion, String pistaId, double precio, double descuento) {
        this.usuarioId = usuarioId;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
        this.pistaId = pistaId;
        this.precio = precio;
        this.descuento = descuento;
    }

    // Getters
    public String getUsuarioId() {
        return usuarioId;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getPistaId() {
        return pistaId;
    }

    public double getPrecio() {
        return precio;
    }

    public double getDescuento() {
        return descuento;
    }

    // Setters
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setPistaId(String pistaId) {
        this.pistaId = pistaId;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuarioId='" + usuarioId + '\'' +
                ", fechaHora=" + fechaHora +
                ", duracion=" + duracion +
                ", pistaId='" + pistaId + '\'' +
                ", precio=" + precio +
                ", descuento=" + descuento +
                '}';
    }
}
