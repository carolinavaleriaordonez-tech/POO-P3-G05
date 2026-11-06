package vista;

import modelo.Actividad;
import modelo.ActividadAcademica;
import modelo.ActividadPersonal;
import modelo.TipoAcademica;
import modelo.TipoPrioridad;
import java.util.List;

public class ActividadVista extends ConsolaVista {

    public ActividadVista() {
        super();
    }

    public int mostrarMenuActividades() {
        mostrarMensaje("\n=== GESTIÓN DE ACTIVIDADES ===");
        mostrarMensaje("1. Visualizar actividades");
        mostrarMensaje("2. Crear actividad");
        mostrarMensaje("3. Registrar avance de actividad");
        mostrarMensaje("4. Eliminar actividad");
        mostrarMensaje("5. Volver al menú principal");
        return leerEntero("Ingrese su opción (1-5): ");
    }

    public void mostrarListadoActividades(List<Actividad> actividades) {
        mostrarMensaje("\nLISTADO DE ACTIVIDADES PENDIENTES");
        mostrarMensaje("ID | TIPO | NOMBRE | VENCIMIENTO | PRIORIDAD | AVANCE");
        mostrarMensaje("-------------------------------------------------------");

        for (int i = 0; i < actividades.size(); i++) {
            Actividad act = actividades.get(i);
            if (act.getAvance() < 100.0) {
                mostrarMensaje(act.getId() + " | " + 
                               act.obtenerEtiquetaTipo() + " | " + 
                               act.getNombre() + " | " + 
                               act.getPrioridad() + " | " + 
                               act.getAvance() + "%");
            }
        }
    }

    public Actividad solicitarDatosNuevaActividad() {
        mostrarMensaje("\n--- CREAR NUEVA ACTIVIDAD ---");
        mostrarMensaje("Seleccione la categoría:");
        mostrarMensaje("1. ACADÉMICA (Tarea, Examen, Proyecto)");
        mostrarMensaje("2. PERSONAL (Citas, Ejercicio, Hobbies)");
        int cat = leerEntero("Ingrese opción (1 o 2): ");

        String nombre = leerCadena("Ingrese el Nombre de la Actividad: ");
        String desc = leerCadena("Ingrese la Descripción: ");
        int tiempo = leerEntero("Ingrese Tiempo Estimado (en minutos/horas): ");
        
        mostrarMensaje("Prioridad: 1. ALTA | 2. MEDIA | 3. BAJA");
        int opPrio = leerEntero("Seleccione opción (1-3): ");
        TipoPrioridad prio = TipoPrioridad.MEDIA;
        if (opPrio == 1) prio = TipoPrioridad.ALTA;
        else if (opPrio == 3) prio = TipoPrioridad.BAJA;

        int idGenerado = (int) (Math.random() * 9000) + 1000;

        if (cat == 1) {
            ActividadAcademica academica = new ActividadAcademica();
            academica.setId(idGenerado);
            academica.setNombre(nombre);
            academica.setDescripcion(desc);
            academica.setTiempoEstimado(tiempo);
            academica.setPrioridad(prio);

            String asignatura = leerCadena("Ingrese la Asignatura: ");
            academica.setAsignatura(asignatura);

            mostrarMensaje("Tipo de Actividad Académica: 1. TAREA | 2. EXAMEN | 3. PROYECTO");
            int tE = leerEntero("Opción (1-3): ");
            if (tE == 1) academica.setTipoEspecifico(TipoAcademica.TAREA);
            else if (tE == 2) academica.setTipoEspecifico(TipoAcademica.EXAMEN);
            else academica.setTipoEspecifico(TipoAcademica.PROYECTO);

            return academica;
        } else {
            ActividadPersonal personal = new ActividadPersonal();
            personal.setId(idGenerado);
            personal.setNombre(nombre);
            personal.setDescripcion(desc);
            personal.setTiempoEstimado(tiempo);
            personal.setPrioridad(prio);

            String lugar = leerCadena("Ingrese el Lugar (Opcional): ");
            personal.setLugar(lugar);

            return personal;
        }
    }

    public double solicitarNuevoAvance() {
        return leerDouble("Ingrese el nuevo porcentaje de avance (0 - 100): ");
    }
}
