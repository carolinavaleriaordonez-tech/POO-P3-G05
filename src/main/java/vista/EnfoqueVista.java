package vista;

public class EnfoqueVista extends ConsolaVista {

    public EnfoqueVista() {
        super();
    }

    public int mostrarMenuTecnicas() {
        mostrarMensaje("\n=== TÉCNICAS DE ENFOQUE (MANEJO DEL TIEMPO) ===");
        mostrarMensaje("1. Iniciar Pomodoro (25 min Trabajo / 5 min Descanso)");
        mostrarMensaje("2. Iniciar Deep Work (Sesión Larga de 90 min)");
        mostrarMensaje("3. Volver al Menú Principal");
        return leerEntero("Ingrese su opción (1-3): ");
    }

    public void mostrarTemporizador(int minutos) {
        mostrarMensaje("Simulando tiempo de trabajo en progreso...");
        mostrarMensaje("[" + minutos + ":00 minutos restantes]");
        leerCadena("Presione [ENTER] para simular la finalización del tiempo...");
    }
}
