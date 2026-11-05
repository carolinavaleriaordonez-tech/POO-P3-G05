package vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import modelo.RegistroHidratacion;

public class VistaHidratacion {
    private static final int ANCHO_BARRA = 20;
    private static final String LINEA = "-------------------------------------";

    private final Scanner scanner;

    public VistaHidratacion(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer mostrarMenu() {
        System.out.println();
        System.out.println("--- C O N T R O L   D E   H I D R A T A C I Ó N ---");
        System.out.println("1. Registrar Ingesta de Agua");
        System.out.println("2. Establecer meta diaria");
        System.out.println("3. Ver Progreso Diario y Meta");
        System.out.println("4. Volver al Menú Principal");
        return pedirEntero("Ingrese su opción: ");
    }
    public void mostrarTitulo(String titulo) {
        System.out.println();
        System.out.println("--- " + titulo + " ---");
    }

    public void mostrarError(String mensaje) {
        System.out.println("[!] " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public Integer pedirEntero(String mensaje) {
        System.out.print(mensaje);
        String linea = scanner.nextLine().trim();
        try {
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean pedirConfirmacion(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (S/N): ");
            String respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("S")) {
                return true;
            }
            if (respuesta.equalsIgnoreCase("N")) {
                return false;
            }
            mostrarError("Responda con S (sí) o N (no).");
        }
    }

    public void esperarEnter(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
    }

    public void mostrarProgresoRapido(int meta, int acumuladoAntes, int acumuladoAhora) {
        System.out.println();
        System.out.println("--- PROGRESO RÁPIDO ---");
        System.out.println("Meta Diaria: " + meta + " ml");
        System.out.println("Acumulado Hoy: " + acumuladoAhora + " ml (Antes eran " + acumuladoAntes + " ml)");
        System.out.println("Progreso: " + construirLineaProgreso(acumuladoAhora, meta));
    }

    public void mostrarProgresoActualizado(int acumulado, int nuevaMeta) {
        System.out.println();
        System.out.println("--- PROGRESO ACTUALIZADO ---");
        System.out.println("Acumulado Hoy: " + acumulado + " ml");
        System.out.println("Nueva Meta: " + nuevaMeta + " ml");
        System.out.println("Progreso: " + construirLineaProgreso(acumulado, nuevaMeta));
    }

    public void mostrarProgresoDiario(Date hoy, int meta, int acumulado, List<RegistroHidratacion> registrosDeHoy) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);

        System.out.println();
        System.out.println("--- PROGRESO DE HIDRATACIÓN DIARIA ---");
        System.out.println("Fecha: " + formatoFecha.format(hoy));
        System.out.println("Meta Diaria (ML): " + meta + " ml");
        System.out.println("Ingesta Acumulada: " + acumulado + " ml");
        System.out.println("Falta: " + Math.max(0, meta - acumulado) + " ml");
        System.out.println("Progreso: " + construirLineaProgreso(acumulado, meta));
        System.out.println();
        System.out.println("Historial de Registros de Hoy:");
        if (registrosDeHoy.isEmpty()) {
            System.out.println("- Aún no has registrado ingesta de agua hoy.");
        } else {
            for (RegistroHidratacion r : registrosDeHoy) {
                System.out.println("- " + formatoHora.format(r.getFecha()) + ": " + r.getCantidadMl() + " ml");
            }
        }
        System.out.println(LINEA);
        if (acumulado >= meta) {
            System.out.println("¡Meta cumplida! Sigue así.");
        } else {
            System.out.println("¡Recuerda mantenerte hidratado!");
        }
    }

    private String construirLineaProgreso(int acumulado, int meta) {
        int porcentaje = meta > 0 ? (int) Math.round(acumulado * 100.0 / meta) : 0;
        int llenos = Math.min(ANCHO_BARRA, porcentaje * ANCHO_BARRA / 100);
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < ANCHO_BARRA; i++) {
            barra.append(i < llenos ? '=' : '-');
        }
        barra.append("] ").append(porcentaje).append("% (").append(acumulado).append("/").append(meta).append(")");
        return barra.toString();
    }
}
