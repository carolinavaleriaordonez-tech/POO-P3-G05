package modelo;

import java.util.Date;

public class RegistroHidratacion {
    private Date fecha;
    private int cantidadMl;
    
    private static int metaDiariaMl = 2000;

    public RegistroHidratacion() {
    }

    public RegistroHidratacion(Date fecha, int cantidadMl) {
        this.fecha = fecha;
        this.cantidadMl = cantidadMl;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadMl() {
        return cantidadMl;
    }

    public void setCantidadMl(int cantidadMl) {
        this.cantidadMl = cantidadMl;
    }

    public static int getMetaDiariaMl() {
        return metaDiariaMl;
    }

    public static void setMetaDiariaMl(int meta) {
        metaDiariaMl = meta;
    }
}