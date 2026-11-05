package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistroHidratacion {
    private Date fecha;
    private List<IngestaAgua> ingestas;

    public RegistroHidratacion() {
        this.ingestas = new ArrayList<>();
    }

    public RegistroHidratacion(Date fecha) {
        this();
        this.fecha = fecha;
    }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public List<IngestaAgua> getIngestas() { return ingestas; }
    public void setIngestas(List<IngestaAgua> ingestas) { this.ingestas = ingestas; }

    public int getAcumuladoMl() {
        int total = 0;
        for (IngestaAgua i : ingestas) {
            total += i.getCantidadMl();
        }
        return total;
    }
}