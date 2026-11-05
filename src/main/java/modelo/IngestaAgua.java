package modelo;

import java.util.Date;

public class IngestaAgua {
    private Date fechaHora;
    private int cantidadMl;

    public IngestaAgua() {
    }

    public IngestaAgua(Date fechaHora, int cantidadMl) {
        this.fechaHora = fechaHora;
        this.cantidadMl = cantidadMl;
    }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public int getCantidadMl() { return cantidadMl; }
    public void setCantidadMl(int cantidadMl) { this.cantidadMl = cantidadMl; }
}
