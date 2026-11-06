package controlador;

import vista.VistaPrincipal;
import vista.ActividadVista;
import vista.EnfoqueVista;
import vista.HidratacionVista;
import vista.SostenibilidadVista;
import vista.MemoriaVista;
import modelo.TableroJuego;
import modelo.Actividad;
import modelo.RegistroHidratacion;
import modelo.RegistroSostenibilidad;
import java.util.ArrayList;
import java.util.List;

public class ControladorPrincipal {
    private VistaPrincipal vistaPrincipal;
    private ActividadControlador actControlador;
    private EnfoqueControlador enfControlador;
    private HidratacionControlador hidControlador;
    private SostenibilidadControlador sosControlador;
    private MemoriaControlador memControlador;

    public ControladorPrincipal() {
        this.vistaPrincipal = new VistaPrincipal();

        // Estructuras de datos en memoria para la app
        List<Actividad> listaActividades = new ArrayList<>();
        List<RegistroHidratacion> listaHidratacion = new ArrayList<>();
        List<RegistroSostenibilidad> listaSostenibilidad = new ArrayList<>();

        // Instanciar controladores secundarios asignando sus vistas y listas
        this.actControlador = new ActividadControlador(listaActividades, new ActividadVista());
        this.enfControlador = new EnfoqueControlador(listaActividades, new EnfoqueVista());
        this.hidControlador = new HidratacionControlador(listaHidratacion, new HidratacionVista());
        this.sosControlador = new SostenibilidadControlador(listaSostenibilidad, new SostenibilidadVista());
        this.memControlador = new MemoriaControlador(new TableroJuego(), new MemoriaVista());
    }

    public VistaPrincipal getVistaPrincipal() { return vistaPrincipal; }
    public void setVistaPrincipal(VistaPrincipal vistaPrincipal) { this.vistaPrincipal = vistaPrincipal; }

    public ActividadControlador getActControlador() { return actControlador; }
    public void setActControlador(ActividadControlador actControlador) { this.actControlador = actControlador; }

    public EnfoqueControlador getEnfControlador() { return enfControlador; }
    public void setEnfControlador(EnfoqueControlador enfControlador) { this.enfControlador = enfControlador; }

    public HidratacionControlador getHidControlador() { return hidControlador; }
    public void setHidControlador(HidratacionControlador hidControlador) { this.hidControlador = hidControlador; }

    public SostenibilidadControlador getSosControlador() { return sosControlador; }
    public void setSosControlador(SostenibilidadControlador sosControlador) { this.sosControlador = sosControlador; }

    public MemoriaControlador getMemControlador() { return memControlador; }
    public void setMemControlador(MemoriaControlador memControlador) { this.memControlador = memControlador; }

    public void inicializarApp() {
        // Carga de datos base en memoria exigidos por el PDF
        vistaPrincipal.mostrarMensaje("Cargando datos iniciales del sistema...");
    }

    public void iniciar() {
        inicializarApp();
        int opcion = 0;

        while (opcion != 6) {
            opcion = vistaPrincipal.mostrarMenuPrincipal();

            if (opcion == 1) {
                actControlador.iniciarModulo();
            } else if (opcion == 2) {
                enfControlador.iniciarModulo();
            } else if (opcion == 3) {
                hidControlador.iniciarModulo();
            } else if (opcion == 4) {
                sosControlador.iniciarModulo();
            } else if (opcion == 5) {
                memControlador.iniciarJuego();
            } else if (opcion == 6) {
                vistaPrincipal.mostrarMensaje("¡Gracias por usar FocusFlow! Hasta luego.");
            } else {
                vistaPrincipal.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
