package modelo;



public class Carta {
    private int id;
    private String contenido;
    private boolean visible;
    private boolean emparejada;


    public Carta() {
        this.id = 0;
        this.contenido = "";
        this.visible = false;
        this.emparejada = false;

    }



    public Carta(int id, String contenido) {

        this.id = id;
        this.contenido = contenido;
        this.visible = false;
        this.emparejada = false;

    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }


    public String getContenido() { return contenido; }

    public void setContenido(String contenido) { this.contenido = contenido; }


    public boolean isVisible() { return visible; }

    public void setVisible(boolean visible) { this.visible = visible; }


    public boolean isEmparejada() { return emparejada; }

    public void setEmparejada(boolean emparejada) { this.emparejada = emparejada; }

}
