package ej3; // O ej2, según sea necesario

import java.util.ArrayList;
import java.util.List;
import ej1.Pista; // Importar desde el paquete correcto
import ej1.Material; // Importar desde el paquete correcto

public class GestorPistas {
    private List<Pista> pistas; // Lista de pistas

    public GestorPistas() {
        pistas = new ArrayList<Pista>(); // Inicializa la lista de pistas
    }

    // Crear pistas
    public void crearPista(Pista pista) {
        pistas.add(pista);
        System.out.println("Pista creada con éxito.");
    }

    // Asociar materiales a pistas
    public void asociarMaterial(Pista pista, Material material) {
        // Implementar lógica para asociar materiales
    }

    // Listar pistas no disponibles

    public List<Pista> listarPistasNoDisponibles() {
        List<Pista> noDisponibles = new ArrayList<>();
        for (Pista pista : pistas) {
            if (!pista.isLibre()) { // Aquí asumimos que la pista no está libre
                noDisponibles.add(pista);
            }
        }
        return noDisponibles;
    } 

    // Obtener pistas libres
    public List<Pista> buscarPistasLibres(int numJugadores, String tipoPista) {
        List<Pista> pistasLibres = new ArrayList<Pista>();  
        for (Pista pista : pistas) {
            if (pista.isLibre() && pista.getTipo().equals(tipoPista) && pista.getCapacidad() >= numJugadores) {
                pistasLibres.add(pista);
            }
        }
        return pistasLibres; 
    }
}  
