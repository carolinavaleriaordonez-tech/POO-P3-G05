package controlador;

import modelo.RegistroSostenibilidad;
import vista.SostenibilidadVista;
import java.util.List;

public class SostenibilidadControlador {
    private List<RegistroSostenibilidad> registros;
    private SostenibilidadVista vistaS;

    public SostenibilidadControlador(List<RegistroSostenibilidad> registros, SostenibilidadVista vista) {
        this.registros = registros;
        this.vistaS = vista;
    }

    public List<RegistroSostenibilidad> getRegistros() { return registros; }
    public void setRegistros(List<RegistroSostenibilidad> registros) { this.registros = registros; }

    public SostenibilidadVista getVistaS() { return vistaS; }
    public void setVistaS(SostenibilidadVista vistaS) { this.vistaS = vistaS; }

    public void iniciarModulo() {
        int opcion = 0;
        while (opcion != 3) {
            opcion = vistaS.mostrarMenuSostenibilidad();
            if (opcion == 1) {
                registrarAccionesDiarias();
            } else if (opcion == 2) {
                generarResumenSemanal();
            } else if (opcion == 3) {
                vistaS.mostrarMensaje("Volviendo al menú principal...");
            }
        }
    }

    public void registrarAccionesDiarias() {
        List<Integer> selecciones = vistaS.solicitarAccionesDiarias();
        RegistroSostenibilidad nuevoRegistro = new RegistroSostenibilidad();
        nuevoRegistro.setAccionesRealizadas(selecciones);
        
        registros.add(nuevoRegistro);
        vistaS.mostrarMensaje("¡Acciones de sostenibilidad registradas exitosamente!");
    }

    public void generarResumenSemanal() {
        vistaS.mostrarResumenSemanal();
    }
}
