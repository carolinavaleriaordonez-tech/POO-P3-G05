package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroSostenibilidad {
    private Date fecha;
    private List<Integer> accionesRealizadas;

    public RegistroSostenibilidad() {
        this.accionesRealizadas = new ArrayList<>();
    }

    public RegistroSostenibilidad(Date fecha, List<Integer> accionesRealizadas) {
        this.fecha = fecha;
        this.accionesRealizadas = accionesRealizadas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Integer> getAccionesRealizadas() {
        return accionesRealizadas;
    }

    public void setAccionesRealizadas(List<Integer> accionesRealizadas) {
        this.accionesRealizadas = accionesRealizadas;
    }
}