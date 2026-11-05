package modelo;

public class MetaHidratacion {
    private int metaDiariaMl;

    public MetaHidratacion() {
        this.metaDiariaMl = 2000;
    }

    public MetaHidratacion(int metaDiariaMl) {
        this.metaDiariaMl = metaDiariaMl;
    }

    public int getMetaDiariaMl() { return metaDiariaMl; }
    public void setMetaDiariaMl(int metaDiariaMl) { this.metaDiariaMl = metaDiariaMl; }
}