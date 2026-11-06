package controlador;

import modelo.Actividad;
import vista.EnfoqueVista;
import java.util.List;

public class EnfoqueControlador {
    private List<Actividad> actividades;
    private EnfoqueVista vistaE;

    public EnfoqueControlador(List<Actividad> actividades, EnfoqueVista vista) {
        this.actividades = actividades;
        this.vistaE = vista;
    }

    public List<Actividad> getActividades() { return actividades; }
    public void setActividades(List<Actividad> actividades) { this.actividades = actividades; }

    public EnfoqueVista getVistaE() { return vistaE; }
    public void setVistaE(EnfoqueVista vistaE) { this.vistaE = vistaE; }

    public void iniciarModulo() {
        int opcion = 0;
        while (opcion != 3) {
            opcion = vistaE.mostrarMenuTecnicas();
            if (opcion == 1) {
                iniciarPomodoro();
            } else if (opcion == 2) {
                iniciarDeepWork();
            } else if (opcion == 3) {
                vistaE.mostrarMensaje("Volviendo al menú principal...");
            }
        }
    }

    public void iniciarPomodoro() {
        int idAct = vistaE.leerEntero("Ingrese el ID de la actividad para aplicar Pomodoro (0 para cancelar): ");
        if (idAct == 0) return;

        vistaE.mostrarMensaje(">>> INICIANDO POMODORO (25 MINUTOS) <<<");
        vistaE.mostrarTemporizador(25);
        vistaE.mostrarMensaje("¡Sesión de Pomodoro completada y registrada!");
    }

    public void iniciarDeepWork() {
        int idAct = vistaE.leerEntero("Ingrese el ID de la actividad para aplicar Deep Work (0 para cancelar): ");
        if (idAct == 0) return;

        vistaE.mostrarMensaje(">>> INICIANDO DEEP WORK (90 MINUTOS) <<<");
        vistaE.mostrarTemporizador(90);
        vistaE.mostrarMensaje("¡Sesión de Deep Work completada y registrada!");
    }
}
