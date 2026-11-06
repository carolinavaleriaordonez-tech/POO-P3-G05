package controlador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import modelo.RegistroHidratacion;
import vista.VistaHidratacion;

public class ControladorHidratacion {

    private static final int LIMITE_INGESTA_ML = 5000;
    private static final int LIMITE_META_ML = 10000;

    private final List<RegistroHidratacion> registros;
    private final VistaHidratacion vista;

    
    public ControladorHidratacion(List<RegistroHidratacion> registros, VistaHidratacion vista) {
        this.registros = registros;
        this.vista = vista;
    }

    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            Integer opcion = vista.mostrarMenu();
            if (opcion == null) {
                vista.mostrarError("Ingrese un número del 1 al 4.");
                continue;
            }
            switch (opcion) {
                case 1:
                    registrarIngesta();
                    break;
                case 2:
                    establecerMeta();
                    break;
                case 3:
                    verProgreso();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    vista.mostrarError("Opción no válida. Ingrese un número del 1 al 4.");
            }
        }
    }

    private void registrarIngesta() {
        vista.mostrarTitulo("REGISTRAR INGESTA DE AGUA");
        int cantidad = -1;
        while (cantidad < 0) {
            Integer ingreso = vista.pedirEntero(
                    "Ingrese la cantidad de agua que ha tomado (en mililitros, ej: 250; 0 para volver): ");
            if (ingreso == null || ingreso < 0 || ingreso > LIMITE_INGESTA_ML) {
                vista.mostrarError("Cantidad no válida. Ingrese un número entero entre 1 y " + LIMITE_INGESTA_ML + ".");
            } else {
                cantidad = ingreso;
            }
        }
        if (cantidad == 0) {
            return; 
        }

        int acumuladoAntes = calcularAcumuladoHoy();
        registros.add(new RegistroHidratacion(new Date(), cantidad));

        vista.mostrarMensaje("Registro de " + cantidad + " ml añadido.");
        vista.mostrarProgresoRapido(RegistroHidratacion.getMetaDiariaMl(), acumuladoAntes, calcularAcumuladoHoy());
        vista.esperarEnter("Presione [ENTER] para continuar...");
    }

    private void establecerMeta() {
        vista.mostrarTitulo("ESTABLECER META DIARIA DE HIDRATACIÓN");
        vista.mostrarMensaje("Meta diaria actual: " + RegistroHidratacion.getMetaDiariaMl() + " ml.");

        int nuevaMeta = -1;
        while (nuevaMeta < 0) {
            Integer ingreso = vista.pedirEntero("Ingrese la nueva meta diaria de hidratación (en mililitros, ej: 3000; 0 para volver): ");
            if (ingreso == null || ingreso < 0 || ingreso > LIMITE_META_ML) {
                vista.mostrarError("Meta no válida. Ingrese un número entero entre 1 y " + LIMITE_META_ML + ".");
            } else {
                nuevaMeta = ingreso;
            }
        }
        if (nuevaMeta == 0) {
            return;
        }

        if (vista.pedirConfirmacion("¿Confirma que la nueva meta diaria es " + nuevaMeta + " ml?")) {
            RegistroHidratacion.setMetaDiariaMl(nuevaMeta);
            vista.mostrarMensaje("Meta diaria de hidratación actualizada a " + nuevaMeta + " ml con éxito.");
            vista.mostrarProgresoActualizado(calcularAcumuladoHoy(), nuevaMeta);
        } else {
            vista.mostrarMensaje("Cambio cancelado. La meta sigue en " + RegistroHidratacion.getMetaDiariaMl() + " ml.");
        }
        vista.esperarEnter("Presione [ENTER] para volver al menú...");
    }

    private void verProgreso() {
        List<RegistroHidratacion> deHoy = obtenerRegistrosDeHoy();
        int acumulado = 0;
        for (RegistroHidratacion r : deHoy) {
            acumulado += r.getCantidadMl();
        }
        vista.mostrarProgresoDiario(new Date(), RegistroHidratacion.getMetaDiariaMl(), acumulado, deHoy);
        vista.esperarEnter("Presione [ENTER] para volver al menú de Hidratación...");
    }

    private int calcularAcumuladoHoy() {
        int total = 0;
        for (RegistroHidratacion r : obtenerRegistrosDeHoy()) {
            total += r.getCantidadMl();
        }
        return total;
    }

    private List<RegistroHidratacion> obtenerRegistrosDeHoy() {
        LocalDate hoy = LocalDate.now();
        List<RegistroHidratacion> deHoy = new ArrayList<>();
        for (RegistroHidratacion r : registros) {
            if (aLocalDate(r.getFecha()).equals(hoy)) {
                deHoy.add(r);
            }
        }
        Collections.sort(deHoy, new ComparadorPorFecha());
        return deHoy;
    }

    private static LocalDate aLocalDate(Date fecha) {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static class ComparadorPorFecha implements Comparator<RegistroHidratacion> {
        public int compare(RegistroHidratacion a, RegistroHidratacion b) {
            return a.getFecha().compareTo(b.getFecha());
        }
    }
}
