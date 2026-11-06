package modelo;

import java.util.Date;

public class SesionEnfoque {
    private Date fecha;
    private TecnicaEnfoque tecnica;
    private int duracionMinutos;

    public SesionEnfoque(Date fecha, TecnicaEnfoque tecnica, int duracionMinutos) {
        this.fecha = fecha;
        this.tecnica = tecnica;
        this.duracionMinutos = duracionMinutos;
    }

    public Date getFecha() { 
        return fecha; 
    }
    public void setFecha(Date fecha) { 
        this.fecha = fecha; 
    }

    public TecnicaEnfoque getTecnica() { 
        return tecnica; 
    }
    public void setTecnica(TecnicaEnfoque tecnica) { 
        this.tecnica = tecnica; 
    }

    public int getDuracionMinutos() { 
        return duracionMinutos; 
    }
    public void setDuracionMinutos(int duracionMinutos) { 
        this.duracionMinutos = duracionMinutos; 
    }
}
