package controlador;

import modelo.Actividad;
import vista.ActividadVista;
import java.util.List;

public class ActividadControlador {
    private List<Actividad> actividades;
    private ActividadVista vistaA;

    public ActividadControlador(List<Actividad> actividades, ActividadVista vistaA) {
        this.actividades = actividades;
        this.vistaA = vistaA;
    }

    public List<Actividad> getActividades() { return actividades; }
    public void setActividades(List<Actividad> actividades) { this.actividades = actividades; }

    public ActividadVista getVistaA() { return vistaA; }
    public void setVistaA(ActividadVista vistaA) { this.vistaA = vistaA; }

    public void iniciarModulo() {
        int opcion = 0;
        while (opcion != 5) {
            opcion = vistaA.mostrarMenuActividades();
            if (opcion == 1) {
                visualizarActividades();
            } else if (opcion == 2) {
                crearActividad();
            } else if (opcion == 3) {
                registrarAvance();
            } else if (opcion == 4) {
                eliminarActividad();
            } else if (opcion == 5) {
                vistaA.mostrarMensaje("Regresando al menú principal...");
            }
        }
    }

    public void crearActividad() {
        Actividad nueva = vistaA.solicitarDatosNuevaActividad();
        if (nueva != null) {
            actividades.add(nueva);
            vistaA.mostrarMensaje("Actividad creada con éxito.");
        }
    }

    public void visualizarActividades() {
        vistaA.mostrarListadoActividades(actividades);
    }

    public void registrarAvance() {
        vistaA.mostrarListadoActividades(actividades);
        int idBuscado = vistaA.leerEntero("Ingrese el ID de la actividad a actualizar (o 0 para cancelar): ");
        if (idBuscado == 0) return;

        Actividad encontrada = null;
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getId() == idBuscado) {
                encontrada = actividades.get(i);
            }
        }

        if (encontrada != null) {
            double nuevoAvance = vistaA.solicitarNuevoAvance();
            encontrada.registrarAvance(nuevoAvance);
            vistaA.mostrarMensaje("Avance actualizado con éxito.");
        } else {
            vistaA.mostrarMensaje("No se encontró ninguna actividad con ese ID.");
        }
    }

    public void eliminarActividad() {
        int idBuscado = vistaA.leerEntero("Ingrese el ID de la actividad a eliminar (o 0 para cancelar): ");
        if (idBuscado == 0) return;

        int posEliminar = -1;
        for (int i = 0; i < actividades.size(); i++) {
            if (actividades.get(i).getId() == idBuscado) {
                posEliminar = i;
            }
        }

        if (posEliminar != -1) {
            actividades.remove(posEliminar);
            vistaA.mostrarMensaje("Actividad eliminada con éxito.");
        } else {
            vistaA.mostrarMensaje("No se encontró ninguna actividad con ese ID.");
        }
    }
}
