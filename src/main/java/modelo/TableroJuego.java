package modelo;

public class TableroJuego {
    private Carta[][] matrizCartas;
    private int intentos;
    private int paresEncontrados;
    private static final int TOTAL_PARES = 8;

    public TableroJuego() {
        this.matrizCartas = new Carta[4][4];
        this.intentos = 0;
        this.paresEncontrados = 0;
    }

    public Carta[][] getMatrizCartas() { return matrizCartas; }
    public void setMatrizCartas(Carta[][] matrizCartas) { this.matrizCartas = matrizCartas; }

    public int getIntentos() { return intentos; }
    public void setIntentos(int intentos) { this.intentos = intentos; }

    public int getParesEncontrados() { return paresEncontrados; }
    public void setParesEncontrados(int paresEncontrados) { this.paresEncontrados = paresEncontrados; }

    public void inicializarTablero() {
    }

    public boolean voltearCartas(int id1, int id2) {
        return false;
    }

    public boolean verificarVictoria() {
        return this.paresEncontrados == TOTAL_PARES;
    }
}