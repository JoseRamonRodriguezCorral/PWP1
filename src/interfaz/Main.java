package interfaz;


import java.util.List;
import java.util.Scanner;
import ej3.GestorUsuarios;
import ej3.GestorPistas;
import ej3.GestorReservas;
import ej1.Jugador;
import ej1.Pista;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import ej2.Reserva;
  

public class Main {

    private static GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private static GestorPistas gestorPistas = new GestorPistas();
    private static GestorReservas gestorReservas = new GestorReservas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Pistas");
            System.out.println("3. Gestión de Reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    menuUsuarios();
                    break;
                case 2:
                    menuPistas();
                    break;
                case 3:
                    menuReservas();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    // Menú para gestionar usuarios
    private static void menuUsuarios() {
        System.out.println("=== Gestión de Usuarios ===");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Modificar Usuario");
        System.out.println("3. Listar Usuarios");
        System.out.println("4. Volver al Menú Principal");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarUsuario();
                break;
            case 2:
                modificarUsuario();
                break;
            case 3:
                listarUsuarios();
                break;
            case 4:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Menú para gestionar pistas
    private static void menuPistas() {
        System.out.println("=== Gestión de Pistas ===");
        System.out.println("1. Crear Pista");
        System.out.println("2. Listar Pistas No Disponibles");
        System.out.println("3. Buscar Pistas Libres");
        System.out.println("4. Volver al Menú Principal");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearPista();
                break;
            case 2:
                listarPistasNoDisponibles();
                break;
            case 3:
                buscarPistasLibres();
                break;
            case 4:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Menú para gestionar reservas
    private static void menuReservas() {
        System.out.println("=== Gestión de Reservas ===");
        System.out.println("1. Crear Reserva Individual");
        System.out.println("2. Crear Reserva con Bono");
        System.out.println("3. Consultar Reservas Futuras");
        System.out.println("4. Consultar Reservas por Día y Pista");
        System.out.println("5. Volver al Menú Principal");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                crearReservaIndividual();
                break;
            case 2:
                crearReservaBono();
                break;
            case 3:
                consultarReservasFuturas();
                break;
            case 4:
                consultarReservasPorDiaYPista();
                break;
            case 5:
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Métodos específicos para cada funcionalidad del menú

    private static void agregarUsuario() {
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la fecha de nacimiento del usuario (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine(); // Leer la fecha como String
        Date fechaNacimiento = null;

        // Convertir el String de fecha a un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaNacimiento = dateFormat.parse(fechaStr); // Intenta parsear la fecha
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
            return; // Salir del método si la fecha no es válida
        }
        
        System.out.print("Ingrese el correo del usuario: ");
        String correo = scanner.nextLine();

        // Declarar la variable bono antes de la estructura condicional
        boolean bono;
        System.out.print("Ingrese si tiene bono (si/no): ");
        String aux = scanner.nextLine();
        
        // Usar .equals() para comparar cadenas
        if (aux.equalsIgnoreCase("si")) {
            bono = true; // Si el usuario dice que tiene bono
        } else {
            bono = false; // Si no
        }

        // Crear una nueva instancia de Jugador
        Jugador nuevoJugador = new Jugador(nombre, fechaNacimiento, correo, bono); // Asegúrate de que el constructor sea correcto
        boolean agregado = gestorUsuarios.agregarUsuario(nuevoJugador);
        
        if (agregado) {
            System.out.println("Usuario agregado con éxito.");
        } else {
            System.out.println("El usuario ya está registrado.");
        }
    }


    private static void modificarUsuario() {
        System.out.print("Ingrese el correo del usuario a modificar: ");
        String correo = scanner.nextLine();

        // Buscar si el usuario existe en el gestor
        Jugador usuarioExistente = null;
        for (Jugador usuario : gestorUsuarios.listarUsuarios()) {
            if (usuario.getCorreo().equals(correo)) {
                usuarioExistente = usuario;
                break;
            }
        }

        if (usuarioExistente == null) {
            System.out.println("Usuario no encontrado con el correo proporcionado.");
            return;
        }

        // Pedir los nuevos datos
        System.out.print("Ingrese el nuevo nombre del usuario: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        Date nuevaFechaNacimiento = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            nuevaFechaNacimiento = dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
            return;
        }
        boolean bono;
        System.out.print("Ingrese si tiene bono (si/no): ");
        String aux = scanner.nextLine();
        
        // Usar .equals() para comparar cadenas
        if (aux.equalsIgnoreCase("si")) {
            bono = true; // Si el usuario dice que tiene bono
        } else {
            bono = false; // Si no
        }
        // Crear un nuevo objeto Jugador con los datos actualizados
        Jugador datosActualizados = new Jugador(nuevoNombre, nuevaFechaNacimiento, correo, bono);
        
        // Actualizar el usuario en el gestor
        boolean modificado = gestorUsuarios.modificarUsuario(correo, datosActualizados);

        if (modificado) {
            System.out.println("Usuario modificado con éxito.");
        } else {
            System.out.println("No se pudo modificar el usuario.");
        }
    }

    private static void listarUsuarios() {
        List<Jugador> usuarios = gestorUsuarios.listarUsuarios();
        for (Jugador usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void crearPista() {
        System.out.print("Ingrese el nombre de la pista: ");
        String nombre = scanner.nextLine();
        // Agregar código para recolectar datos de la pista y crearla en el gestor
	    System.out.print("¿Está disponible? (true/false): ");
	    boolean disponible = scanner.nextBoolean();
	    
	    System.out.print("¿Es interior? (true/false): ");
	    boolean interior = scanner.nextBoolean();
	
	    System.out.print("Seleccione el tamaño de la pista (MINIBASKET, ADULTOS, TRES_VS_TRES): ");
	    String tamañoStr = scanner.nextLine();
	    Pista.TamañoPista tamaño = Pista.TamañoPista.valueOf(tamañoStr.toUpperCase());
	
	    System.out.print("Ingrese el número máximo de jugadores: ");
	    int maxJugadores = scanner.nextInt();
	    scanner.nextLine();  // Limpiar el buffer
	
	    // Crear la pista con los datos recolectados
	    Pista nuevaPista = new Pista(nombre, disponible, interior, tamaño, maxJugadores);
	
	    // Agregar la nueva pista al gestor de pistas
	    gestorPistas.crearPista(nuevaPista);  // Asegúrate de tener este método en GestorPistas
	
	    System.out.println("Pista creada exitosamente: " + nuevaPista);
    }

    private static void listarPistasNoDisponibles() {
        List<Pista> noDisponibles = gestorPistas.listarPistasNoDisponibles();
        for (Pista pista : noDisponibles) {
            System.out.println(pista);
        }
    }
    


  /*  private static void buscarPistasLibres() {
        System.out.print("Ingrese el número de jugadores: ");
        int jugadores = scanner.nextInt();
        System.out.print("¿Es interior? (true/false): ");
        boolean interior = scanner.nextBoolean();
        List<Pista> libres = gestorPistas.buscarPistasLibres(jugadores, interior);
        for (Pista pista : libres) {
            System.out.println(pista);
        } 
    }*/
    
    private static void buscarPistasLibres() {
        System.out.print("Ingrese el número de jugadores: ");
        int jugadores = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el tipo de pista (por ejemplo: 'normal' o 'premium'): ");
        String tipoPista = scanner.nextLine(); // Cambiar boolean a String

        List<Pista> libres = gestorPistas.buscarPistasLibres(jugadores, tipoPista);
        for (Pista pista : libres) {
            System.out.println(pista);
        } 
    }

    

    private static void crearReservaIndividual() {
        System.out.print("Ingrese el correo del usuario ");
        String correo = scanner.nextLine();
			
        // Buscar si el usuario existe en el gestor
        // Buscar si el usuario existe en el gestor
        Jugador usuarioExistente = null;
        for (Jugador usuario : gestorUsuarios.listarUsuarios()) {
            if (usuario.getCorreo().equals(correo)) {
                usuarioExistente = usuario;
                break;
            }
        }
        if (usuarioExistente == null) {
            System.out.println("Usuario no encontrado con el correo proporcionado.");
            return;
        }

        // Recolectar detalles de la reserva
        System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        Date fechaReserva;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaReserva = dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
            return;
        }

        System.out.print("Ingrese el ID de la pista: ");
        String pistaId = scanner.nextLine();

        // Crear una instancia de reserva
        Reserva reserva = new Reserva(usuarioExistente.getCorreo(), fechaReserva, 60, pistaId, 100.0, 0.0);
		//usuarioid
       
     // Intentar hacer la reserva a través del gestor
        gestorReservas.hacerReservaIndividual(reserva , usuarioExistente); 
 
        
        //gestorReservas.hacerReservaIndividual(reserva, usuarioExistente);
    }

   private static void crearReservaBono() {
    System.out.print("Ingrese el correo del usuario: ");
    String correo = scanner.nextLine();

    // Buscar si el usuario existe en el gestor
    Jugador usuarioExistente = null;
    for (Jugador usuario : gestorUsuarios.listarUsuarios()) {
        if (usuario.getCorreo().equals(correo)) {
            usuarioExistente = usuario;
            break;
        }
    } 

    if (usuarioExistente == null) {
        System.out.println("Usuario no encontrado con el correo proporcionado.");
        return;
    }
    boolean bono =usuarioExistente.getBono();
    //System.out.print("Ingrese el id del bono: ");
    //)String id = scanner.nextLine();
    // Verificar si el usuario tiene un bono activo
   // Bono bono = id; // Cambiado de usuario a usuarioExistente
    if (bono == false) {
        System.out.println("El usuario no tiene un bono activo.");
        return;
    }

    // Recolectar detalles de la reserva
    System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
    String fechaStr = scanner.nextLine();
    Date fechaReserva;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
        fechaReserva = dateFormat.parse(fechaStr);
    } catch (ParseException e) {
        System.out.println("Formato de fecha inválido. Debe ser YYYY-MM-DD.");
        return;
    }

    System.out.print("Ingrese el ID de la pista: ");
    String pistaId = scanner.nextLine();

    // Crear una instancia de reserva
    Reserva reserva = new Reserva(usuarioExistente.getCorreo(), fechaReserva, 60, pistaId, 100.0, 0.0);// Cambiado de usuario a usuarioExistente

    // Intentar hacer la reserva usando el bono
    gestorReservas.hacerReservaBono(usuarioExistente.getBono(), reserva);
    
    }

    private static void consultarReservasFuturas() {
        int futuras = gestorReservas.consultarReservasFuturas();
        System.out.println("Reservas futuras: " + futuras);
    }

    private static void consultarReservasPorDiaYPista() {
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        System.out.print("Ingrese el ID de la pista: ");
        String pistaId = scanner.nextLine();
        // Convertir la fecha e implementar la consulta al gestor de reservas
    Date fecha = null;
    try {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fecha = formato.parse(fechaStr);
    } catch (ParseException e) {
        System.out.println("Formato de fecha inválido. Asegúrese de usar YYYY-MM-DD.");
        return;
    }

    // Obtener las reservas del gestor
    List<Reserva> reservas = gestorReservas.consultarReservasPorDiaYPista(fecha, pistaId);

    // Mostrar las reservas encontradas
    if (reservas.isEmpty()) {
        System.out.println("No hay reservas para la fecha y la pista especificadas.");
    } else {
        System.out.println("Reservas encontradas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
    }

}

