import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingresa numero entero ");
            int numero = scanner.nextInt(); // Intenta leer un valor numérico
            
            System.out.println("Correcto El numero entero ingresado es: " + numero);
            
        } catch (InputMismatchException e) {
            // Se ejecuta si el usuario ingresa letras o símbolos en lugar de números
            System.err.println("Ingrese un numero entero por favor!");
        } finally {
            // Buena práctica: cerrar el recurso del scanner al finalizar
            scanner.close();
        }

    }
}
