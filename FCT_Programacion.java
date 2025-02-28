package FCT_Programacion;

import java.util.Scanner;

public class FCT_Programacion {
    static String[] usuarios = new String[100];
    static String[] correos = new String[100];
    static String[] contrasenas = new String[100];
    static int usuarioCount = 0;
    
    static String[] eventos = new String[50];
    static String[] fechas = new String[50];
    static int eventoCount = 0;
    
    static int[] inscripcionesUsuarios = new int[200];
    static int[] inscripcionesEventos = new int[200];
    static int inscripcionCount = 0;
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE EVENTOS ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Registrar evento");
            System.out.println("3. Inscribir usuario a evento");
            System.out.println("4. Mostrar eventos");
            System.out.println("5. Mostrar inscripciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    registrarEvento();
                    break;
                case 3:
                    inscribirUsuario();
                    break;
                case 4:
                    mostrarEventos();
                    break;
                case 5:
                    mostrarInscripciones();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
    
    static void registrarUsuario() {
        if (usuarioCount >= 100) {
            System.out.println("No se pueden registrar más usuarios.");
            return;
        }
        System.out.print("Ingrese nombre de usuario: ");
        usuarios[usuarioCount] = scanner.nextLine();
        System.out.print("Ingrese correo electrónico: ");
        correos[usuarioCount] = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        contrasenas[usuarioCount] = scanner.nextLine();
        System.out.println("Usuario registrado con éxito.");
        usuarioCount++;
    }
    
    static void registrarEvento() {
        if (eventoCount >= 50) {
            System.out.println("No se pueden registrar más eventos.");
            return;
        }
        System.out.print("Ingrese nombre del evento: ");
        eventos[eventoCount] = scanner.nextLine();
        System.out.print("Ingrese fecha del evento (YYYY-MM-DD): ");
        fechas[eventoCount] = scanner.nextLine();
        System.out.println("Evento registrado con éxito.");
        eventoCount++;
    }
    
    static void inscribirUsuario() {
        if (inscripcionCount >= 200) {
            System.out.println("No se pueden registrar más inscripciones.");
            return;
        }
        System.out.println("Seleccione un usuario:");
        for (int i = 0; i < usuarioCount; i++) {
            System.out.println(i + ". " + usuarios[i]);
        }
        System.out.print("Ingrese número de usuario: ");
        int usuarioIndex = scanner.nextInt();
        
        System.out.println("Seleccione un evento:");
        for (int i = 0; i < eventoCount; i++) {
            System.out.println(i + ". " + eventos[i]);
        }
        System.out.print("Ingrese número de evento: ");
        int eventoIndex = scanner.nextInt();
        
        if (usuarioIndex < usuarioCount && eventoIndex < eventoCount) {
            inscripcionesUsuarios[inscripcionCount] = usuarioIndex;
            inscripcionesEventos[inscripcionCount] = eventoIndex;
            inscripcionCount++;
            System.out.println("Usuario inscrito con éxito en el evento.");
        } else {
            System.out.println("Selección inválida.");
        }
    }
    
    static void mostrarEventos() {
        System.out.println("\n--- LISTA DE EVENTOS ---");
        for (int i = 0; i < eventoCount; i++) {
            System.out.println((i + 1) + ". " + eventos[i] + " - " + fechas[i]);
        }
    }
    
    static void mostrarInscripciones() {
        System.out.println("\n--- LISTA DE INSCRIPCIONES ---");
        for (int i = 0; i < inscripcionCount; i++) {
            System.out.println(usuarios[inscripcionesUsuarios[i]] + " (" + correos[inscripcionesUsuarios[i]] + ") está inscrito en " + eventos[inscripcionesEventos[i]]);
        }
    }
}