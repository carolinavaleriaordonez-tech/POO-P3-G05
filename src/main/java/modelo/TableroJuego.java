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
        inicializarTablero();
    }

    public Carta[][] getMatrizCartas() { 
        return matrizCartas; 
    }
    public void setMatrizCartas(Carta[][] matrizCartas) { 
        this.matrizCartas = matrizCartas; 
    }

    public int getIntentos() { 
        return intentos; 
    }
    public void setIntentos(int intentos) { 
        this.intentos = intentos; 
    }

    public int getParesEncontrados() { 
        return paresEncontrados; 
    }
    public void setParesEncontrados(int paresEncontrados) { 
        this.paresEncontrados = paresEncontrados; 
    }

    public void inicializarTablero() {
        String[] contenidosBase = {
            "RECIC", "BICI", "AGUA", "SOLAR",
            "FAUNA", "ARBOL", "BIO", "VIENTO"
        };

        Carta[] cartasTemp = new Carta[16];
        int idContador = 1;

        for (int i = 0; i < TOTAL_PARES; i++) {
            Carta c1 = new Carta();
            c1.setId(idContador++);
            c1.setContenido(contenidosBase[i]);

            Carta c2 = new Carta();
            c2.setId(idContador++);
            c2.setContenido(contenidosBase[i]);

            cartasTemp[i * 2] = c1;
            cartasTemp[i * 2 + 1] = c2;
        }

        // Mezclar cartas con Math.random()
        for (int i = 0; i < 16; i++) {
            int posAleatoria = (int) (Math.random() * 16);
            Carta temp = cartasTemp[i];
            cartasTemp[i] = cartasTemp[posAleatoria];
            cartasTemp[posAleatoria] = temp;
        }

        // Pasar a la matriz 4x4
        int indice = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                matrizCartas[r][c] = cartasTemp[indice];
                indice++;
            }
        }
    }

    private Carta buscarCartaPorId(int id) {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (matrizCartas[r][c] != null && matrizCartas[r][c].getId() == id) {
                    return matrizCartas[r][c];
                }
            }
        }
        return null;
    }

    public boolean voltearCartas(int id1, int id2) {
        Carta c1 = buscarCartaPorId(id1);
        Carta c2 = buscarCartaPorId(id2);

        if (c1 == null || c2 == null) {
            return false;
        }
        if (c1.isVisible() == true || c2.isVisible() == true) {
            return false;
        }
        if (c1.isEmparejada() == true || c2.isEmparejada() == true) {
            return false;
        }

        intentos++;
        c1.setVisible(true);
        c2.setVisible(true);

        if (c1.getContenido() == c2.getContenido()) {
            c1.setEmparejada(true);
            c2.setEmparejada(true);
            paresEncontrados++;
            return true;
        }
        return false;
    }

    public void ocultarCartas(int id1, int id2) {
        Carta c1 = buscarCartaPorId(id1);
        Carta c2 = buscarCartaPorId(id2);

        if (c1 != null && c1.isEmparejada() == false) {
            c1.setVisible(false);
        }
        if (c2 != null && c2.isEmparejada() == false) {
            c2.setVisible(false);
        }
    }

    public boolean verificarVictoria() {
        return paresEncontrados == TOTAL_PARES;
    }
}
