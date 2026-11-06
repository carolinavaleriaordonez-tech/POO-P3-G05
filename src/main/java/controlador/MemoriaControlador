package controlador;

import modelo.TableroJuego;
import vista.MemoriaVista;

public class MemoriaControlador {
    private TableroJuego tablero;
    private MemoriaVista vistaM;

    public MemoriaControlador(TableroJuego tablero, MemoriaVista vista) {
        this.tablero = tablero;
        this.vistaM = vista;
    }

    public TableroJuego getTablero() {
        return tablero;
    }

    public void setTablero(TableroJuego tablero) {
        this.tablero = tablero;
    }

    public MemoriaVista getVistaM() {
        return vistaM;
    }

    public void setVistaM(MemoriaVista vistaM) {
        this.vistaM = vistaM;
    }

    public void iniciarJuego() {
        vistaM.mostrarMensaje("=== JUEGO DE MEMORIA ECOLÓGICO ===");
        vistaM.mostrarMensaje("¡Encuentra los 8 pares!");
        vistaM.mostrarTablero(tablero);
        
        vistaM.leerCadena("Presione [ENTER] para comenzar...");

        // Bucle principal del juego mientras no se gane
        while (tablero.verificarVictoria() == false) {
            jugarTurno();
        }

        vistaM.mostrarMensaje("¡FELICITACIONES! Has completado el juego en " + tablero.getIntentos() + " intentos.");
    }

    public void jugarTurno() {
        vistaM.mostrarMensaje("--- TURNO " + (tablero.getIntentos() + 1) + " | SELECCIÓN ---");
        
        int id1 = vistaM.solicitarCoordenadasCarta(1);
        int id2 = vistaM.solicitarCoordenadasCarta(2);

        // Validación si elige la misma carta
        if (id1 == id2) {
            vistaM.mostrarMensaje("⚠️ No puedes seleccionar la misma carta dos veces.");
            vistaM.leerCadena("Presione [ENTER] para continuar...");
            return;
        }

        boolean acierto = tablero.voltearCartas(id1, id2);
        
        vistaM.mostrarMensaje("Volteando cartas...");
        vistaM.mostrarTablero(tablero);
        vistaM.mostrarResultadoTurno(acierto);

        if (acierto == false) {
            tablero.ocultarCartas(id1, id2);
        }

        vistaM.leerCadena("Presione [ENTER] para continuar...");
    }
}
