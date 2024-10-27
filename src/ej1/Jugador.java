package ej1;

import java.util.Date;


public class Jugador {
    private String nombre;
    private Date fechaNacimiento;
    private Date fechaInscripcion;
    private String correo;
    private boolean bono;

    // Constructor por defecto
    public Jugador() {}

    // Constructor con parámetros
    public Jugador(String nombre, Date fechaNacimiento, String correo,boolean bono ) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInscripcion = new Date();  // Fecha actual
        this.correo = correo;
        this.bono= bono;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }
    
    public boolean getBono() {
    	return bono;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setBono(boolean bono) {
    	this.bono=bono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularAntiguedad() {
        long diffMillis = new Date().getTime() - fechaInscripcion.getTime();
        return (int) (diffMillis / (1000 * 60 * 60 * 24 * 365)); // Aproximación de años
    }

    @Override
    public String toString() {
        return "Jugador[Nombre: " + nombre + ", Fecha Nacimiento: " + fechaNacimiento + ", Fecha Inscripcion: " + fechaInscripcion + ", Correo: " + correo + "bono: "+ bono+ "]";
    }
}
