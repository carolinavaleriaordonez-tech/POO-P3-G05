package vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VistaSostenibilidad {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String LINEA = "----------------------------------------------------------------------";

    private final Scanner scanner;

    public VistaSostenibilidad(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarAcciones(LocalDate hoy, String[] acciones) {
        System.out.println();
        System.out.println("--- REGISTRO DIARIO DE SOSTENIBILIDAD (" + hoy.format(FORMATO_FECHA) + ") ---");
        System.out.println("Marque las acciones que realizó hoy (ingrese los números separados por coma,");
        System.out.println("ej: 1, 3):");
        for (int i = 0; i < acciones.length; i++) {
            System.out.println((i + 1) + ". " + acciones[i]);
        }
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarError(String mensaje) {
        System.out.println("[!] " + mensaje);
    }

    public void esperarEnter(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
    }

    public void mostrarAccionesRegistradas(List<String> descripciones, boolean actualizado) {
        System.out.println("----------------------------------------");
        if (actualizado) {
            System.out.println("Ya tenías un registro de hoy; fue actualizado.");
        }
        System.out.println("Acciones de sostenibilidad registradas:");
        for (String d : descripciones) {
            System.out.println("- " + d);
        }
        System.out.println("¡Excelente contribución al planeta hoy!");
    }

    public void mostrarResumenSemanal(LocalDate inicio, LocalDate fin, String[] nombres, int[] veces,
                                      String[] logros, int totalDias, int diasConAccion,
                                      int diasCompletos, String tip) {
        System.out.println();
        System.out.println("--- RESUMEN SEMANAL DE SOSTENIBILIDAD (" + inicio.format(FORMATO_FECHA) + " - " + fin.format(FORMATO_FECHA) + ") ---");
        System.out.println(LINEA);
        System.out.println("FRECUENCIA DE ACCIONES");
        System.out.println(LINEA);
        System.out.println(String.format("%-43s|%-17s|%s", "ACCIÓN", " VECES REALIZADA", " LOGRO"));
        System.out.println("-------------------------------------------|-----------------|---------------");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(String.format("%-43s| %-15s | %s", nombres[i],
                    veces[i] + " / " + totalDias + " Días", logros[i]));
        }
        System.out.println(LINEA);
        System.out.println("ANÁLISIS ECOLÓGICO");
        System.out.println(LINEA);
        System.out.println("Días con al menos 1 acción de sostenibilidad: " + diasConAccion + " de " + totalDias
                + " (" + porcentaje(diasConAccion, totalDias) + "%)");
        System.out.println("Días con las " + nombres.length + " acciones completas: " + diasCompletos + " de "
                + totalDias + " (" + porcentaje(diasCompletos, totalDias) + "%)");
        System.out.println();
        System.out.println("Tip Ecológico de la Semana: " + tip);
        System.out.println(LINEA);
    }

    private static int porcentaje(int parte, int total) {
        return total == 0 ? 0 : (int) Math.round(parte * 100.0 / total);
    }
}
