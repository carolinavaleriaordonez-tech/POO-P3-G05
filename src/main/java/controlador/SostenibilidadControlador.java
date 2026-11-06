package controlador;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import modelo.RegistroSostenibilidad;
import vista.VistaSostenibilidad;

public class ControladorSostenibilidad {

    private static final String[] ACCIONES = {
        "Usé transporte público, bicicleta o caminé.",
        "No realicé impresiones.",
        "No utilicé envases descartables (usé mi termo/taza).",
        "Separé y reciclé materiales (vidrio, plástico, papel)."
    };

    private static final String[] ACCIONES_CORTAS = {
        "Usé transporte público/bici/caminé",
        "No realicé impresiones",
        "No utilicé envases descartables",
        "Separé y reciclé materiales"
    };

    private static final String[] TIPS = {
        "Planifica tus trayectos para combinar caminata o bicicleta con transporte público.",
        "Revisa en pantalla y comparte documentos digitalmente antes de imprimir.",
        "Ten siempre tu botella reutilizable a la mano antes de salir.",
        "Deja contenedores separados en casa para que reciclar sea más fácil."
    };

    private static final int DIAS_RESUMEN = 7;

    private final List<RegistroSostenibilidad> registros;
    private final VistaSostenibilidad vista;

    public ControladorSostenibilidad(List<RegistroSostenibilidad> registros, VistaSostenibilidad vista) {
        this.registros = registros;
        this.vista = vista;
    }

    public void ejecutar() {
        LocalDate hoy = LocalDate.now();
        vista.mostrarAcciones(hoy, ACCIONES);

        List<Integer> seleccion = pedirSelecciones();
        if (seleccion == null) {
            return; 
        }

        boolean actualizado = guardarRegistroDeHoy(hoy, seleccion);
        List<String> descripciones = new ArrayList<>();
        for (int numero : seleccion) {
            descripciones.add(ACCIONES[numero - 1]);
        }
        vista.mostrarAccionesRegistradas(descripciones, actualizado);

        vista.esperarEnter("Presione [ENTER] para ver el resumen semanal...");
        mostrarResumenSemanal(hoy);
        vista.esperarEnter("Presione [ENTER] para volver al menú principal...");
    }

    private List<Integer> pedirSelecciones() {
        while (true) {
            String linea = vista.pedirTexto("Ingrese sus selecciones (ej: 1, 3, 4; 0 para volver): ").trim();
            if (linea.equals("0")) {
                return null;
            }
            List<Integer> seleccion = interpretar(linea);
            if (seleccion != null) {
                return seleccion;
            }
            vista.mostrarError("Entrada no válida. Use números del 1 al " + ACCIONES.length
                    + " separados por coma. Ejemplo: 1, 3, 4");
        }
    }

    private List<Integer> interpretar(String linea) {
        if (linea.isEmpty()) {
            return null;
        }
        Set<Integer> numeros = new TreeSet<>();
        for (String parte : linea.split(",")) {
            try {
                int numero = Integer.parseInt(parte.trim());
                if (numero < 1 || numero > ACCIONES.length) {
                    return null;
                }
                numeros.add(numero);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return new ArrayList<>(numeros);
    }

    private boolean guardarRegistroDeHoy(LocalDate hoy, List<Integer> seleccion) {
        for (RegistroSostenibilidad r : registros) {
            if (aLocalDate(r.getFecha()).equals(hoy)) {
                r.setAccionesRealizadas(seleccion);
                return true;
            }
        }
        registros.add(new RegistroSostenibilidad(new Date(), seleccion));
        return false;
    }

    private void mostrarResumenSemanal(LocalDate hoy) {
        int[] veces = new int[ACCIONES.length];
        int diasConAccion = 0;
        int diasCompletos = 0;

        for (int i = DIAS_RESUMEN - 1; i >= 0; i--) {
            Set<Integer> delDia = accionesDelDia(hoy.minusDays(i));
            for (int numero : delDia) {
                veces[numero - 1]++;
            }
            if (!delDia.isEmpty()) {
                diasConAccion++;
            }
            if (delDia.size() == ACCIONES.length) {
                diasCompletos++;
            }
        }

        String[] logros = new String[ACCIONES.length];
        int menor = 0;
        for (int i = 0; i < ACCIONES.length; i++) {
            logros[i] = calcularLogro(veces[i]);
            if (veces[i] < veces[menor]) {
                menor = i;
            }
        }

        vista.mostrarResumenSemanal(hoy.minusDays(DIAS_RESUMEN - 1), hoy, ACCIONES_CORTAS, veces, logros,
                DIAS_RESUMEN, diasConAccion, diasCompletos, TIPS[menor]);
    }

    private Set<Integer> accionesDelDia(LocalDate dia) {
        Set<Integer> acciones = new TreeSet<>();
        for (RegistroSostenibilidad r : registros) {
            if (aLocalDate(r.getFecha()).equals(dia)) {
                acciones.addAll(r.getAccionesRealizadas());
            }
        }
        return acciones;
    }

    private static String calcularLogro(int dias) {
        if (dias >= 6) {
            return "Excelente";
        } else if (dias >= 5) {
            return "Muy bien";
        } else if (dias >= 1) {
            return "Necesita mejorar";
        }
        return "¡Empieza hoy!";
    }

    private static LocalDate aLocalDate(Date fecha) {
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
