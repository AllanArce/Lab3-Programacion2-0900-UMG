import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa una cadena de texto para convertir a número entero: ");
        String texto = scanner.nextLine();

        try {
            // Intenta convertir el texto ingresado a un número entero
            int numeroConvertido = Integer.parseInt(texto);
            
            System.out.println("¡Conversión exitosa! El número es: " + numeroConvertido);
            System.out.println("El doble del número es: " + (numeroConvertido * 2));

        } catch (NumberFormatException e) {
            // Se ejecuta si el texto no se puede transformar a número (ej: "abc", "12.5", "10a")
            System.err.println("Error: No se pudo convertir '" + texto + "' a un número entero válido.");
            System.err.println("Detalle del error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Proceso de conversión finalizado.");
        }
    }

}
