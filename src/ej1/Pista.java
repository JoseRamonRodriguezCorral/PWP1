package ej1;

import java.util.ArrayList;
import java.util.List;

public class Pista {
    public enum TamañoPista { MINIBASKET, ADULTOS, TRES_VS_TRES }

    private String nombre;
    private boolean disponible;
    private boolean interior;
    private TamañoPista tamaño;
    private int maxJugadores;
    private List<Material> materiales;

    public Pista() {
        materiales = new ArrayList<>();
    }

    public Pista(String nombre, boolean disponible, boolean interior, TamañoPista tamaño, int maxJugadores) {
        this.nombre = nombre;
        this.disponible = disponible;
        this.interior = interior;
        this.tamaño = tamaño;
        this.maxJugadores = maxJugadores;
        this.materiales = new ArrayList<>();
    }

    // Método para obtener la capacidad (número máximo de jugadores)
    public int getCapacidad() {
        return maxJugadores; // Retorna el máximo de jugadores que puede tener la pista
    }

    // Método para obtener el tipo de pista
    public TamañoPista getTipo() {
        return tamaño; // Retorna el tipo de pista
    }

    public void asociarMaterialAPista(Material material) {
        if (interior || !material.isUsoExterior()) {
            if (contarMaterialTipo(material.getTipo()) < maxPermitido(material.getTipo())) {
                materiales.add(material);
            } else {
                System.out.println("Límite de materiales alcanzado.");
            }
        } else {
            System.out.println("Material incompatible con el tipo de pista.");
        }
    }

    private int contarMaterialTipo(Material.TipoMaterial tipo) {
        int count = 0;
        for (Material m : materiales) {
            if (m.getTipo().equals(tipo)) count++;
        }
        return count;
    }

    private int maxPermitido(Material.TipoMaterial tipo) {
        switch (tipo) {
            case PELOTAS: return 12;
            case CANASTAS: return 2;
            case CONOS: return 20;
            default: return 0;
        }
    }

    public List<Material> consultarMaterialesDisponibles() {
        List<Material> disponibles = new ArrayList<>();
        for (Material m : materiales) {
            if (m.getEstado() == Material.EstadoMaterial.DISPONIBLE) {
                disponibles.add(m);
            }
        }
        return disponibles;
    }

    public boolean isLibre() {
        return disponible; // El método isLibre retorna el estado de la pista
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible; // Permite cambiar la disponibilidad de la pista
    }

    @Override
    public String toString() {
        return "Pista[Nombre: " + nombre + ", Disponible: " + disponible + ", Interior: " + interior + ", Tamaño: " + tamaño + ", Max Jugadores: " + maxJugadores + "]";
    }
}
