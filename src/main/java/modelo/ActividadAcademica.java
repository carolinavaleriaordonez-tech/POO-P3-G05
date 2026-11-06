package modelo;

public class ActividadAcademica extends Actividad {
    private String asignatura;
    private TipoAcademica tipoEspecifico;

    public ActividadAcademica() {
        super();
    }

    public String getAsignatura() { 
        return asignatura; 
    }
    public void setAsignatura(String asignatura) { 
        this.asignatura = asignatura; 
    }

    public TipoAcademica getTipoEspecifico() { 
        return tipoEspecifico; 
    }
    public void setTipoEspecifico(TipoAcademica tipoEspecifico) { 
        this.tipoEspecifico = tipoEspecifico; 
    }

    @Override
    public String obtenerEtiquetaTipo() {
        if (tipoEspecifico == TipoAcademica.TAREA) {
            return "TAREA";
        } else if (tipoEspecifico == TipoAcademica.EXAMEN) {
            return "EXAMEN";
        } else if (tipoEspecifico == TipoAcademica.PROYECTO) {
            return "PROYECTO";
        }
        return "ACADÉMICA";
    }
}
