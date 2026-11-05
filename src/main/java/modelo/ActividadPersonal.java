package modelo;

import java.util.Date;

public class ActividadPersonal extends Actividad {
    private String lugar;

    public ActividadPersonal() {
        super();
    }

    public ActividadPersonal(int id, String nombre, String descripcion, Date fechaVencimiento, TipoPrioridad prioridad, int tiempoEstimado, String lugar) {
        super(id, nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado);
        this.lugar = lugar;
    }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    @Override
    public String obtenerEtiquetaTipo() {
        return "PERSONAL";
    }
}
