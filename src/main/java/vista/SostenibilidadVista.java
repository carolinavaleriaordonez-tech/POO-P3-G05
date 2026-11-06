package vista;

import java.util.ArrayList;
import java.util.List;

public class SostenibilidadVista extends ConsolaVista {

    public SostenibilidadVista() {
        super();
    }

    public int mostrarMenuSostenibilidad() {
        mostrarMensaje("\n=== REGISTRO DIARIO DE SOSTENIBILIDAD ===");
        mostrarMensaje("1. Registrar Acciones de Hoy");
        mostrarMensaje("2. Ver Resumen Semanal");
        mostrarMensaje("3. Volver al Menú Principal");
        return leerEntero("Ingrese su opción (1-3): ");
    }

    public List<Integer> solicitarAccionesDiarias() {
        mostrarMensaje("\nMarque las acciones realizadas hoy:");
        mostrarMensaje("1. Usé transporte público, bicicleta o caminé.");
        mostrarMensaje("2. No realicé impresiones.");
        mostrarMensaje("3. No utilicé envases descartables (usé termo/taza).");
        mostrarMensaje("4. Separé y reciclé materiales (vidrio, plástico, papel).");

        List<Integer> selecciones = new ArrayList<>();
        mostrarMensaje("Ingrese el número de cada acción realizada (ingrese 0 para finalizar):");
        
        int opcion = -1;
        while (opcion != 0) {
            opcion = leerEntero("Acción (1-4 o 0 para terminar): ");
            if (opcion >= 1 && opcion <= 4) {
                selecciones.add(opcion);
            }
        }
        return selecciones;
    }

    public void mostrarResumenSemanal() {
        mostrarMensaje("\n--- RESUMEN SEMANAL DE SOSTENIBILIDAD ---");
        mostrarMensaje("ACCIÓN                            | VECES REALIZADA");
        mostrarMensaje("---------------------------------------------------");
        mostrarMensaje("1. Transporte público/bici/caminar | 5/7 Días");
        mostrarMensaje("2. No realizó impresiones          | 7/7 Días");
        mostrarMensaje("3. No utilizó envases descartables | 4/7 Días");
        mostrarMensaje("4. Separó y recicló materiales    | 5/7 Días");
        mostrarMensaje("\nTip Ecológico de la Semana: Mantén tu termo reutilizable a la mano antes de salir.");
        leerCadena("\nPresione [ENTER] para volver...");
    }
}
