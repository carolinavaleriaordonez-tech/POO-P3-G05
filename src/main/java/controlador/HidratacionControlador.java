package controlador;

import modelo.RegistroHidratacion;
import vista.HidratacionVista;
import java.util.List;

public class HidratacionControlador {
    private List<RegistroHidratacion> registros;
    private HidratacionVista vistaH;

    public HidratacionControlador(List<RegistroHidratacion> registros, HidratacionVista vista) {
        this.registros = registros;
        this.vistaH = vista;
    }

    public List<RegistroHidratacion> getRegistros() { return registros; }
    public void setRegistros(List<RegistroHidratacion> registros) { this.registros = registros; }

    public HidratacionVista getVistaH() { return vistaH; }
    public void setVistaH(HidratacionVista vistaH) { this.vistaH = vistaH; }

    public void iniciarModulo() {
        int opcion = 0;
        while (opcion != 4) {
            opcion = vistaH.mostrarMenuHidratacion();
            if (opcion == 1) {
                registrarIngesta();
            } else if (opcion == 2) {
                establecerMeta();
            } else if (opcion == 3) {
                verProgreso();
            } else if (opcion == 4) {
                vistaH.mostrarMensaje("Volviendo al menú principal...");
            }
        }
    }

    public void registrarIngesta() {
        int cantidadMl = vistaH.solicitarIngesta();
        RegistroHidratacion nuevo = new RegistroHidratacion();
        nuevo.setCantidadMl(cantidadMl);
        registros.add(nuevo);

        vistaH.mostrarMensaje("Registro de " + cantidadMl + " ml añadido con éxito.");
    }

    public void establecerMeta() {
        int nuevaMeta = vistaH.solicitarNuevaMeta();
        // Se actualiza a través del método estático según la indicación del profesor
        RegistroHidratacion.setMetaDiariaMl(nuevaMeta);
        vistaH.mostrarMensaje("Meta diaria actualizada a " + nuevaMeta + " ml.");
    }

    public void verProgreso() {
        int acumulado = 0;
        for (int i = 0; i < registros.size(); i++) {
            acumulado = acumulado + registros.get(i).getCantidadMl();
        }
        int metaActual = RegistroHidratacion.getMetaDiariaMl();
        vistaH.mostrarProgresoDiario(metaActual, acumulado);
    }
}
