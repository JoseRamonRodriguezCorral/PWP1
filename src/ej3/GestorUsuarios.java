package ej3;

import java.util.ArrayList;
import java.util.List;
import ej1.Jugador;

public class GestorUsuarios {
    private List<Jugador> usuarios;

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    public boolean agregarUsuario(Jugador nuevoUsuario) {
        for (Jugador usuario : usuarios) {
            if (usuario.getCorreo().equals(nuevoUsuario.getCorreo())) {
                return false;  // Usuario ya registrado
            }
        }
        usuarios.add(nuevoUsuario);
        return true;
    }

    public boolean modificarUsuario(String correo, Jugador datosActualizados) {
        for (Jugador usuario : usuarios) {
            if (usuario.getCorreo().equals(correo)) {
                usuario.setNombre(datosActualizados.getNombre());
                usuario.setFechaNacimiento(datosActualizados.getFechaNacimiento());
                return true;
            }
        }
        return false;  // Usuario no encontrado
    }

    public List<Jugador> listarUsuarios() {
        return usuarios;
    }
}
