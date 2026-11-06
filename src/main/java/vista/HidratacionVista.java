package vista;

public class HidratacionVista extends ConsolaVista {

    public HidratacionVista() {
        super();
    }

    public int mostrarMenuHidratacion() {
        mostrarMensaje("\n=== CONTROL DE HIDRATACIÓN ===");
        mostrarMensaje("1. Registrar Ingesta de Agua");
        mostrarMensaje("2. Establecer meta diaria");
        mostrarMensaje("3. Ver Progreso Diario y Meta");
        mostrarMensaje("4. Volver al Menú Principal");
        return leerEntero("Ingrese su opción (1-4): ");
    }

    public int solicitarIngesta() {
        return leerEntero("Ingrese la cantidad de agua tomada (en mililitros): ");
    }

    public int solicitarNuevaMeta() {
        return leerEntero("Ingrese la nueva meta diaria de hidratación (en mililitros): ");
    }

    public void mostrarProgresoDiario(int meta, int acumulado) {
        mostrarMensaje("\n--- PROGRESO DE HIDRATACIÓN DIARIA ---");
        mostrarMensaje("Meta Diaria: " + meta + " ml");
        mostrarMensaje("Ingesta Acumulada: " + acumulado + " ml");
        
        int falta = meta - acumulado;
        if (falta < 0) falta = 0;
        mostrarMensaje("Falta por tomar: " + falta + " ml");

        int porcentaje = 0;
        if (meta > 0) {
            porcentaje = (acumulado * 100) / meta;
        }
        
        mostrarMensaje("Progreso total: " + porcentaje + "%");
        mostrarMensaje("¡Recuerda mantenerte hidratado!");
        leerCadena("\nPresione [ENTER] para volver al menú...");
    }
}
