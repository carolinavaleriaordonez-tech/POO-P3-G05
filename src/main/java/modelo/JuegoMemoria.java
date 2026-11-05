package modelo;

public class JuegoMemoria {
    private TableroJuego tablero;

    public JuegoMemoria() {
        this.tablero = new TableroJuego();
    }

    public TableroJuego getTablero() { return tablero; }
    public void setTablero(TableroJuego tablero) { this.tablero = tablero; }
}