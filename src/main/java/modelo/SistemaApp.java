package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaApp {
    private List<Actividad> actividades;
    private List<RegistroHidratacion> registrosHidratacion;
    private List<RegistroSostenibilidad> registrosSostenibilidad;
    private MetaHidratacion metaHidratacion;

    public SistemaApp() {
        this.actividades = new ArrayList<>();
        this.registrosHidratacion = new ArrayList<>();
        this.registrosSostenibilidad = new ArrayList<>();
        this.metaHidratacion = new MetaHidratacion(2500);
    }

    public List<Actividad> getActividades() { return actividades; }
    public void setActividades(List<Actividad> actividades) { this.actividades = actividades; }

    public List<RegistroHidratacion> getRegistrosHidratacion() { return registrosHidratacion; }
    public void setRegistrosHidratacion(List<RegistroHidratacion> registrosHidratacion) { this.registrosHidratacion = registrosHidratacion; }

    public List<RegistroSostenibilidad> getRegistrosSostenibilidad() { return registrosSostenibilidad; }
    public void setRegistrosSostenibilidad(List<RegistroSostenibilidad> registrosSostenibilidad) { this.registrosSostenibilidad = registrosSostenibilidad; }

    public MetaHidratacion getMetaHidratacion() { return metaHidratacion; }
    public void setMetaHidratacion(MetaHidratacion metaHidratacion) { this.metaHidratacion = metaHidratacion; }

    public void inicializarApp() {
    }
}
