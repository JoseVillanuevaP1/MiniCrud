package utils;

import java.util.Scanner;

public class Lectura {

    private Scanner teclado = new Scanner(System.in);

    public String cadena() {
        return teclado.nextLine();
    }

    public String cadenaMayuscula() {
        return cadena().toUpperCase();
    }

    public String cadenaMinuscula() {
        return cadena().toLowerCase();
    }

    public int entero() {
        return Integer.valueOf(cadena());
    }

    public double decimal() {
        return Double.valueOf(cadena());
    }

    public char letra() {
        return cadena().charAt(0);
    }
}
