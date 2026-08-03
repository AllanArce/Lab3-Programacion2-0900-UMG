import java.util.InputMismatchException;
import java.util.Scanner;

class ExcepcionPersonalizada extends Exception {
    public ExcepcionPersonalizada(String mensaje) {
        super(mensaje);
    }
}

public class EjerciciosRestantes {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Ejercicio 25: Menú interactivo principal
        int opcion = -1;

        do {
            mostrarMenu();
            try {
                System.out.print("\nSeleccione un ejercicio (1-25) o 0 para salir: ");
                opcion = Integer.parseInt(scanner.nextLine());

                System.out.println("\n------------------------------------------------");
                switch (opcion) {
                    case 1  -> ejercicio01();
                    case 2  -> ejercicio02();
                    case 3  -> ejercicio03();
                    case 4  -> ejercicio04();
                    case 5  -> ejercicio05();
                    case 6  -> ejercicio06();
                    case 7  -> ejercicio07();
                    case 8  -> ejercicio08();
                    case 9  -> ejercicio09();
                    case 10 -> ejercicio10();
                    case 11 -> ejercicio11();
                    case 12 -> ejercicio12();
                    case 13 -> ejercicio13();
                    case 14 -> ejercicio14();
                    case 15 -> ejercicio15();
                    case 16 -> ejercicio16();
                    case 17 -> ejercicio17();
                    case 18 -> ejercicio18();
                    case 19 -> ejercicio19();
                    case 20 -> ejercicio20();
                    case 21 -> ejercicio21();
                    case 22 -> ejercicio22();
                    case 23 -> ejercicio23();
                    case 24 -> ejercicio24();
                    case 25 -> System.out.println("El menú interactivo es el programa que estás ejecutando.");
                    case 0  -> System.out.println("¡Saliendo del programa! Éxito en tu laboratorio.");
                    default -> System.out.println("Opción no válida. Ingrese un número entre 0 y 25.");
                }
                System.out.println("------------------------------------------------\n");

            } catch (NumberFormatException e) {
                // Ejercicio 23: Controlar error en entrada del usuario
                System.err.println("\nError: Debe ingresar un número entero válido para la opción del menú.");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println("       LABORATORIO III - NIVEL 1 (EJERCICIOS 1-25)");
        System.out.println("==================================================");
        System.out.println("1. Divisi\u00f3n entre cero                14. Crear excepci\u00f3n personalizada");
        System.out.println("2. Validar entrada num\u00e9rica           15. Lanzar excepci\u00f3n personalizada");
        System.out.println("3. Texto a n\u00famero (NumberFormat)     16. Validar texto no vac\u00edo");
        System.out.println("4. Mensaje personalizado              17. Capturar charAt fuera de rango");
        System.out.println("5. Bloque finally                     18. Divisi\u00f3n segura con m\u00e9todo");
        System.out.println("6. Validar n\u00famero positivo           19. Validar n\u00famero mayor a 100");
        System.out.println("7. Lanzar si es negativo (throw)      20. Simular error controlado");
        System.out.println("8. Manejar excepci\u00f3n de m\u00e9todo        21. Validar email simple");
        System.out.println("9. Validar edad (no negativa)         22. Validar longitud de texto");
        System.out.println("10. Validar contrase\u00f1a m\u00ednima        23. Controlar error en entrada");
        System.out.println("11. Arreglo e \u00edndice fuera de rango   24. Reintentar lectura tras error");
        System.out.println("12. Catch m\u00faltiples                   25. Men\u00fa con manejo de errores");
        System.out.println("13. Usar throw manualmente            0. Salir");
        System.out.println("==================================================");
    }

    // --- EJERCICIOS INDIVIDUALES ---

    // 1. Capturar excepción al dividir entre cero
    private static void ejercicio01() {
        System.out.println("--- Ejercicio 1: Divisi\u00f3n entre cero ---");
        try {
            int a = 10, b = 0;
            int r = a / b;
            System.out.println("Resultado: " + r);
        } catch (ArithmeticException e) {
            System.err.println("Error capturado: Intentaste dividir " + e.getMessage());
        }
    }

    // 2. Validar entrada numérica con try-catch
    private static void ejercicio02() {
        System.out.println("--- Ejercicio 2: Validar entrada num\u00e9rica ---");
        System.out.print("Ingrese un n\u00famero: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            System.out.println("Ingresaste correctamente el n\u00famero: " + num);
        } catch (NumberFormatException e) {
            System.err.println("Error: La entrada no es un n\u00famero entero.");
        }
    }

    // 3. Manejar error al convertir texto a número
    private static void ejercicio03() {
        System.out.println("--- Ejercicio 3: Texto a n\u00famero ---");
        String textoInvalido = "123a";
        try {
            int valor = Integer.parseInt(textoInvalido);
            System.out.println("Valor: " + valor);
        } catch (NumberFormatException e) {
            System.err.println("No se pudo convertir '" + textoInvalido + "' a entero: " + e.getMessage());
        }
    }

    // 4. Mostrar mensaje personalizado en excepción
    private static void ejercicio04() {
        System.out.println("--- Ejercicio 4: Mensaje personalizado ---");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.err.println("Mensaje Personalizado: Referencia nula detectada. Operaci\u00f3n cancelada.");
        }
    }

    // 5. Usar finally para mostrar mensaje final
    private static void ejercicio05() {
        System.out.println("--- Ejercicio 5: Bloque finally ---");
        try {
            System.out.println("Ejecutando operaci\u00f3n...");
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Ocurri\u00f3 un error en la divisi\u00f3n.");
        } finally {
            System.out.println("Bloque FINALLY: Este mensaje SIEMPRE se muestra al terminar.");
        }
    }

    // 6. Pedir número y validar que sea positivo (con excepción)
    private static void ejercicio06() {
        System.out.println("--- Ejercicio 6: Validar positivo ---");
        System.out.print("Ingrese un n\u00famero positivo: ");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            if (n <= 0) {
                throw new IllegalArgumentException("El n\u00famero ingresado no es positivo.");
            }
            System.out.println("N\u00famero positivo v\u00e1lido: " + n);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // 7 y 8. Método que lanza y maneja excepción si un número es negativo
    private static void validarNoNegativo(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("El n\u00famero " + n + " es negativo.");
        }
    }

    private static void ejercicio07() {
        System.out.println("--- Ejercicio 7 y 8: M\u00e9todo que lanza y maneja excepci\u00f3n si es negativo ---");
        try {
            validarNoNegativo(-10);
        } catch (IllegalArgumentException e) {
            System.err.println("Excepci\u00f3n capturada desde m\u00e9todo: " + e.getMessage());
        }
    }

    private static void ejercicio08() {
        ejercicio07(); // Cumple la misma funci\u00f3n de demostraci\u00f3n
    }

    // 9. Validar edad (no negativa)
    private static void ejercicio09() {
        System.out.println("--- Ejercicio 9: Validar edad ---");
        System.out.print("Ingrese su edad: ");
        try {
            int edad = Integer.parseInt(scanner.nextLine());
            if (edad < 0 || edad > 120) {
                throw new IllegalArgumentException("La edad debe ser un valor razonable (0-120).");
            }
            System.out.println("Edad registrada: " + edad + " a\u00f1os.");
        } catch (Exception e) {
            System.err.println("Error de validaci\u00f3n de edad: " + e.getMessage());
        }
    }

    // 10. Validar contraseña mínima (usar excepción)
    private static void ejercicio10() {
        System.out.println("--- Ejercicio 10: Validar contrase\u00f1a m\u00ednima ---");
        System.out.print("Ingrese una contrase\u00f1a (m\u00ednimo 8 caracteres): ");
        String pass = scanner.nextLine();
        try {
            if (pass.length() < 8) {
                throw new Exception("La contrase\u00f1a es demasiado corta (m\u00ednimo 8 caracteres).");
            }
            System.out.println("Contrase\u00f1a aceptada de forma segura.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // 11. Leer arreglo y capturar índice fuera de rango
    private static void ejercicio11() {
        System.out.println("--- Ejercicio 11: Arreglo e \u00edndice fuera de rango ---");
        int[] datos = {10, 20, 30};
        try {
            System.out.println("Accediendo al \u00edndice 5...");
            int val = datos[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: \u00cdndice fuera de rango. El arreglo solo tiene longitud " + datos.length);
        }
    }

    // 12. Manejar múltiples excepciones (catch múltiples)
    private static void ejercicio12() {
        System.out.println("--- Ejercicio 12: Catch m\u00faltiples ---");
        try {
            String[] lista = {"100", "abc"};
            int num = Integer.parseInt(lista[1]); // Genera NumberFormatException
            int res = num / 0;                   // Podr\u00eda generar ArithmeticException
        } catch (NumberFormatException e) {
            System.err.println("Captura 1 (Formato): No se pudo convertir la cadena a n\u00famero.");
        } catch (ArithmeticException e) {
            System.err.println("Captura 2 (Aritm\u00e9tica): Divisi\u00f3n por cero no permitida.");
        } catch (Exception e) {
            System.err.println("Captura General: Ocurri\u00f3 un error no especificado.");
        }
    }

    // 13. Usar throw manualmente
    private static void ejercicio13() {
        System.out.println("--- Ejercicio 13: Usar throw manualmente ---");
        try {
            System.out.println("Provocando excepci\u00f3n con 'throw'...");
            throw new RuntimeException("Excepci\u00f3n lanzada manualmente a prop\u00f3sito.");
        } catch (RuntimeException e) {
            System.err.println("Capturado exitosamente: " + e.getMessage());
        }
    }

    // 14 y 15. Crear y lanzar excepción personalizada
    private static void ejercicio14() {
        System.out.println("--- Ejercicio 14: Ver la clase ExcepcionPersonalizada arriba ---");
        System.out.println("La clase 'ExcepcionPersonalizada extends Exception' ya est\u00e1 declarada en este archivo.");
    }

    private static void ejercicio15() {
        System.out.println("--- Ejercicio 15: Lanzar excepci\u00f3n personalizada ---");
        try {
            throw new ExcepcionPersonalizada("¡Error cr\u00edtico personalizado desde el Ejercicio 15!");
        } catch (ExcepcionPersonalizada e) {
            System.err.println("Captura personalizada: " + e.getMessage());
        }
    }

    // 16. Validar que texto no esté vacío
    private static void ejercicio16() {
        System.out.println("--- Ejercicio 16: Validar texto no vac\u00edo ---");
        System.out.print("Ingrese un texto no vac\u00edo: ");
        String txt = scanner.nextLine();
        try {
            if (txt.trim().isEmpty()) {
                throw new IllegalArgumentException("El texto ingresado no puede estar vac\u00edo ni contener solo espacios.");
            }
            System.out.println("Texto v\u00e1lido: '" + txt + "'");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // 17. Manejar error al acceder a charAt
    private static void ejercicio17() {
        System.out.println("--- Ejercicio 17: Error en charAt ---");
        String palabra = "Java";
        try {
            System.out.println("Buscando el car\u00e1cter en la posici\u00f3n 10 de '" + palabra + "'...");
            char c = palabra.charAt(10);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Error: \u00cdndice fuera de los l\u00edmites del texto. Longitud m\u00e1xima: " + palabra.length());
        }
    }

    // 18. Validar división segura con método
    private static double divisionSegura(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("El divisor no puede ser cero.");
        }
        return a / b;
    }

    private static void ejercicio18() {
        System.out.println("--- Ejercicio 18: Divisi\u00f3n segura ---");
        try {
            System.out.println("Resultado de 20 / 4: " + divisionSegura(20, 4));
            System.out.println("Resultado de 10 / 0: " + divisionSegura(10, 0));
        } catch (ArithmeticException e) {
            System.err.println("Error en divisi\u00f3n segura: " + e.getMessage());
        }
    }

    // 19. Validar número mayor a 100
    private static void ejercicio19() {
        System.out.println("--- Ejercicio 19: Validar n\u00famero mayor a 100 ---");
        System.out.print("Ingrese un n\u00famero mayor a 100: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num <= 100) {
                throw new Exception("El n\u00famero " + num + " NO es mayor a 100.");
            }
            System.out.println("¡Excelente! " + num + " es mayor a 100.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // 20. Simular error controlado con throw
    private static void ejercicio20() {
        System.out.println("--- Ejercicio 20: Simular error controlado ---");
        try {
            boolean conexionExitosa = false;
            System.out.println("Intentando conectar con servidor...");
            if (!conexionExitosa) {
                throw new Exception("Simulaci\u00f3n: Fallo en la conexi\u00f3n a la base de datos.");
            }
        } catch (Exception e) {
            System.err.println("Error Controlado: " + e.getMessage());
        }
    }

    // 21. Crear método que valide email simple
    private static void validarEmail(String email) throws Exception {
        if (!email.contains("@") || !email.contains(".")) {
            throw new Exception("El email '" + email + "' no tiene un formato v\u00e1lido (debe incluir '@' y '.').");
        }
    }

    private static void ejercicio21() {
        System.out.println("--- Ejercicio 21: Validar email ---");
        System.out.print("Ingrese su correo electr\u00f3nico: ");
        String mail = scanner.nextLine();
        try {
            validarEmail(mail);
            System.out.println("Correo electr\u00f3nico v\u00e1lido: " + mail);
        } catch (Exception e) {
            System.err.println("Error de validaci\u00f3n: " + e.getMessage());
        }
    }

    // 22. Validar longitud de texto con excepción
    private static void ejercicio22() {
        System.out.println("--- Ejercicio 22: Validar longitud de texto ---");
        System.out.print("Ingrese un resumen (m\u00e1ximo 15 caracteres): ");
        String texto = scanner.nextLine();
        try {
            if (texto.length() > 15) {
                throw new Exception("El texto excede el l\u00edmite de 15 caracteres (Longitud: " + texto.length() + ").");
            }
            System.out.println("Texto aceptado: " + texto);
        } catch (Exception e) {
            System.err.println("Error de longitud: " + e.getMessage());
        }
    }

    // 23. Controlar error en entrada de usuario
    private static void ejercicio23() {
        System.out.println("--- Ejercicio 23: Controlar error en entrada ---");
        System.out.print("Ingrese su c\u00f3digo de usuario (solo n\u00fameros): ");
        try {
            int codigo = Integer.parseInt(scanner.nextLine());
            System.out.println("C\u00f3digo v\u00e1lido: " + codigo);
        } catch (NumberFormatException e) {
            System.err.println("Entrada no v\u00e1lida: Se esperaban solo d\u00edgitos num\u00e9ricos.");
        }
    }

    // 24. Reintentar lectura si ocurre error
    private static void ejercicio24() {
        System.out.println("--- Ejercicio 24: Reintentar lectura si ocurre error ---");
        boolean exito = false;
        while (!exito) {
            try {
                System.out.print("Ingrese su nota (0-100): ");
                int nota = Integer.parseInt(scanner.nextLine());
                if (nota < 0 || nota > 100) {
                    throw new Exception("La nota debe estar entre 0 y 100.");
                }
                System.out.println("Nota guardada correctamente: " + nota);
                exito = true; // Sale del bucle cuando la entrada es válida
            } catch (Exception e) {
                System.err.println("Entrada inv\u00e1lida: " + e.getMessage() + " Intente de nuevo.\n");
            }
        }
    }

}
