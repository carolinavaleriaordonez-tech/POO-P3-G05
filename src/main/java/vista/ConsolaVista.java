package vista;

import java.util.Scanner;

public class ConsolaVista {
    protected Scanner scanner;

    public ConsolaVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerCadena(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int leerEntero(String prompt) {
        System.out.print(prompt);
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del teclado
        return valor;
    }

    public double leerDouble(String prompt) {
        System.out.print(prompt);
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del teclado
        return valor;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
