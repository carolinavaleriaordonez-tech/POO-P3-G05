package vista;

public class VistaPrincipal extends ConsolaVista {

    public VistaPrincipal() {
        super(); // Inicializa el Scanner del padre (ConsolaVista)
    }

    public int mostrarMenuPrincipal() {
        mostrarMensaje("\n=================================");
        mostrarMensaje("          FOCUSFLOW              ");
        mostrarMensaje("=================================");
        mostrarMensaje("1. Gestión de Actividades");
        mostrarMensaje("2. Técnicas de Enfoque (Manejo de tiempo)");
        mostrarMensaje("3. Control de hidratación");
        mostrarMensaje("4. Registro diario de Sostenibilidad");
        mostrarMensaje("5. Juego de memoria");
        mostrarMensaje("6. Salir");
        mostrarMensaje("=================================");
        return leerEntero("Ingrese su opción (1-6): ");
    }
}
