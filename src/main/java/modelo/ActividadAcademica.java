package modelo;

import java.util.Date;

public class ActividadAcademica extends Actividad {
    private String asignatura;
    private TipoAcademica tipoEspecifico;

    public ActividadAcademica() {
        super();
    }

    public ActividadAcademica(int id, String nombre, String descripcion, Date fechaVencimiento, TipoPrioridad prioridad, int tiempoEstimado, String asignatura, TipoAcademica tipoEspecifico) {
        super(id, nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado);
        this.asignatura = asignatura;
        this.tipoEspecifico = tipoEspecifico;
    }

    public String getAsignatura() { return asignatura; }
    public void setAsignatura(String asignatura) { this.asignatura = asignatura; }

    public TipoAcademica getTipoEspecifico() { return tipoEspecifico; }
    public void setTipoEspecifico(TipoAcademica tipoEspecifico) { this.tipoEspecifico = tipoEspecifico; }

    @Override
    public String obtenerEtiquetaTipo() {
        return this.tipoEspecifico != null ? this.tipoEspecifico.name() : "ACADÉMICA";
    }
}
