package modelo;

import java.util.Date;

public class RegistroHidratacion {
    private Date fecha;
    private int cantidadMl;
    
    // Meta diaria como atributo estático
    private static int metaDiariaMl = 2500;

    public RegistroHidratacion() {
        this.fecha = new Date();
        this.cantidadMl = 0;
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
        RegistroHidratacion.metaDiariaMl = meta; 
    }
}
