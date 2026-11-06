package vista;

import modelo.Carta;
import modelo.TableroJuego;

public class MemoriaVista extends ConsolaVista {

    public MemoriaVista() {
        super(); // Inicializa el scanner del padre ConsolaVista
    }

    public void mostrarTablero(TableroJuego tablero) {
        Carta[][] matriz = tablero.getMatrizCartas();
        
        mostrarMensaje("\n+---------+---------+---------+---------+");
        for (int r = 0; r < 4; r++) {
            System.out.print("|");
            for (int c = 0; c < 4; c++) {
                Carta carta = matriz[r][c];
                
                if (carta.isVisible() == true || carta.isEmparejada() == true) {
                    System.out.print("  " + carta.getContenido() + "  |");
                } else {
                    System.out.print("    " + carta.getId() + "    |");
                }
            }
            System.out.println("\n+---------+---------+---------+---------+");
        }
        mostrarMensaje("Total de Intentos: " + tablero.getIntentos() + " | Pares Encontrados: " + tablero.getParesEncontrados() + "/8\n");
    }

    public int solicitarCoordenadasCarta(int numeroCarta) {
        if (numeroCarta == 1) {
            return leerEntero("Ingrese el número de la PRIMERA carta: ");
        } else {
            return leerEntero("Ingrese el número de la SEGUNDA carta: ");
        }
    }

    public void mostrarResultadoTurno(boolean acierto) {
        if (acierto == true) {
            mostrarMensaje("¡PAR ENCONTRADO! Las cartas se mantienen descubiertas.");
        } else {
            mostrarMensaje("❌ ¡ERROR! Las cartas no coinciden. Serán cubiertas de nuevo.");
        }
    }
}
