package modelo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Actividad {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaVencimiento;
    private TipoPrioridad prioridad;
    private double avance;
    private int tiempoEstimado;
    private List<SesionEnfoque> historialTiempos;
    private EstadoActividad estado;

    public Actividad() {
        this.avance = 0.0;
        this.historialTiempos = new ArrayList<>();
        this.estado = EstadoActividad.PENDIENTE;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    public Date getFechaVencimiento() { 
        return fechaVencimiento; 
    }
    public void setFechaVencimiento(Date fechaVencimiento) { 
        this.fechaVencimiento = fechaVencimiento; 
    }

    public TipoPrioridad getPrioridad() { 
        return prioridad; 
    }
    public void setPrioridad(TipoPrioridad prioridad) { 
        this.prioridad = prioridad; 
    }

    public double getAvance() { 
        return avance; 
    }
    public void setAvance(double avance) { 
        this.avance = avance; 
    }

    public int getTiempoEstimado() { 
        return tiempoEstimado; 
    }
    public void setTiempoEstimado(int tiempoEstimado) { 
        this.tiempoEstimado = tiempoEstimado; 
    }

    public List<SesionEnfoque> getHistorialTiempos() { 
        return historialTiempos; 
    }
    public void setHistorialTiempos(List<SesionEnfoque> historialTiempos) { 
        this.historialTiempos = historialTiempos; 
    }

    public EstadoActividad getEstado() { 
        return estado; 
    }
    public void setEstado(EstadoActividad estado) { 
        this.estado = estado; 
    }

    public void registrarAvance(double nuevoAvance) {
        this.avance = nuevoAvance;
        if (this.avance >= 100.0) {
            this.estado = EstadoActividad.FINALIZADA;
        } else if (this.avance > 0.0) {
            this.estado = EstadoActividad.EN_CURSO;
        }
    }

    public void agregarSesionEnfoque(SesionEnfoque sesion) {
        if (sesion != null) {
            this.historialTiempos.add(sesion);
        }
    }

    public String obtenerEtiquetaTipo() {
        return "GENERAL";
    }
}
