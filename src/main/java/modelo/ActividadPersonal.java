package modelo;

public class ActividadPersonal extends Actividad {
    private String lugar;

    public ActividadPersonal() {
        super();
    }

    public String getLugar() { 
        return lugar; 
    }
    public void setLugar(String lugar) { 
        this.lugar = lugar; 
    }

    @Override
    public String obtenerEtiquetaTipo() {
        return "PERSONAL";
    }
}
