import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ============================================================================
// CLASES AUXILIARES (NIVEL 2: POO BÁSICA)
// ============================================================================

// --- 1. CLASE PERSONA (Ejercicios 1 a 5) ---
class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.err.println("Error: La edad no puede ser negativa.");
        }
    }

    public void mostrarDatos() {
        System.out.println("Persona -> Nombre: " + nombre + " | Edad: " + edad + " años");
    }
}

// --- 2. CLASE CUENTA (Ejercicios 6 a 10) ---
class Cuenta {
    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            System.err.println("Error: Saldo inicial negativo. Se ajustó a Q0.0");
            this.saldo = 0.0;
        }
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito exitoso de Q" + monto);
        } else {
            System.err.println("Error: El monto a depositar debe ser positivo.");
        }
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.err.println("Error: El monto a retirar debe ser mayor a cero.");
        } else if (monto > this.saldo) {
            System.err.println("Error: Fondos insuficientes. Intenta retirar Q" + monto + " pero sólo hay Q" + this.saldo);
        } else {
            this.saldo -= monto;
            System.out.println("Retiro exitoso de Q" + monto);
        }
    }

    public void mostrarSaldo() {
        System.out.println("Cuenta de " + titular + " -> Saldo disponible: Q" + String.format("%.2f", saldo));
    }
}

// --- 3. CLASE PRODUCTO (Ejercicios 11 a 15) ---
class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.err.println("Error: El precio debe ser un número positivo.");
            this.precio = 1.0;
        }
    }

    public void mostrarProducto() {
        System.out.println("Producto: " + nombre + " | Precio: Q" + String.format("%.2f", precio));
    }
}

// --- 4. CLASE ESTUDIANTE (Ejercicios 16 a 20) ---
class Estudiante {
    private String nombre;
    private List<Double> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public void agregarNota(double nota) {
        if (nota >= 0 && nota <= 100) {
            this.notas.add(nota);
            System.out.println("Nota " + nota + " registrada a " + nombre);
        } else {
            System.err.println("Error: La nota " + nota + " debe estar en el rango de 0 a 100.");
        }
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }

    public void mostrarResultado() {
        System.out.println("\nEstudiante: " + nombre);
        System.out.println("Notas registradas: " + notas);
        System.out.println("Promedio general: " + String.format("%.2f", calcularPromedio()));
    }
}

// --- 5. CLASE EMPLEADO (Ejercicios 21 a 25) ---
class Empleado {
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        setSalario(salario);
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            System.err.println("Error: El salario debe ser positivo.");
            this.salario = 3000.0;
        }
    }

    public double getSalario() {
        return salario;
    }

    public void mostrarDatos() {
        System.out.println("Empleado: " + nombre + " | Puesto: " + puesto + " | Salario: Q" + String.format("%.2f", salario));
    }
}

// ============================================================================
// CLASE PRINCIPAL (Nombre de tu archivo EjerciciosPOOBasica.java)
// ============================================================================

public class EjerciciosPOOBasica {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        do {
            mostrarMenu();
            try {
                System.out.print("\nSeleccione el módulo a probar (1-5) o 0 para salir: ");
                opcion = Integer.parseInt(scanner.nextLine());

                System.out.println("\n------------------------------------------------");
                switch (opcion) {
                    case 1 -> probarClasePersona();
                    case 2 -> probarClaseCuenta();
                    case 3 -> probarClaseProducto();
                    case 4 -> probarClaseEstudiante();
                    case 5 -> probarClaseEmpleado();
                    case 0 -> System.out.println("¡Finalizando pruebas de POO Básica!");
                    default -> System.out.println("Opción no válida. Elija un número entre 0 y 5.");
                }
                System.out.println("------------------------------------------------\n");

            } catch (NumberFormatException e) {
                System.err.println("\nError: Debe ingresar un número entero válido.");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println("      LABORATORIO III - NIVEL 2 (POO BÁSICA)");
        System.out.println("==================================================");
        System.out.println("1. Pruebas Módulo PERSONA (Ejercicios 1-5)");
        System.out.println("2. Pruebas Módulo CUENTA BANCARIA (Ejercicios 6-10)");
        System.out.println("3. Pruebas Módulo PRODUCTO Y LISTAS (Ejercicios 11-15)");
        System.out.println("4. Pruebas Módulo ESTUDIANTE Y NOTAS (Ejercicios 16-20)");
        System.out.println("5. Pruebas Módulo EMPLEADO Y Objetos (Ejercicios 21-25)");
        System.out.println("0. Salir");
        System.out.println("==================================================");
    }

    private static void probarClasePersona() {
        System.out.println("--- 1. Pruebas Clase Persona ---");
        Persona p1 = new Persona("Carlos Gómez", 25);
        p1.mostrarDatos();

        System.out.println("\nProbando validación de edad negativa (-5):");
        p1.setEdad(-5);
        p1.mostrarDatos();
    }

    private static void probarClaseCuenta() {
        System.out.println("--- 2. Pruebas Clase Cuenta ---");
        Cuenta miCuenta = new Cuenta("María López", 500.0);
        miCuenta.mostrarSaldo();

        System.out.println("\nDepositando Q200...");
        miCuenta.depositar(200);

        System.out.println("\nIntentando retirar Q1000 (Excede saldo)...");
        miCuenta.retirar(1000);

        System.out.println("\nRetirando Q300 de forma correcta...");
        miCuenta.retirar(300);
        miCuenta.mostrarSaldo();
    }

    private static void probarClaseProducto() {
        System.out.println("--- 3. Pruebas Clase Producto y Lista ---");
        List<Producto> inventario = new ArrayList<>();
        inventario.add(new Producto("Laptop", 4500.00));
        inventario.add(new Producto("Mouse Óptico", 85.50));
        
        System.out.println("Intentando crear un producto con precio negativo (-20)...");
        inventario.add(new Producto("Teclado Inválido", -20.00));

        System.out.println("\n--- Lista de Productos Registrados ---");
        for (Producto prod : inventario) {
            prod.mostrarProducto();
        }
    }

    private static void probarClaseEstudiante() {
        System.out.println("--- 4. Pruebas Clase Estudiante ---");
        Estudiante est = new Estudiante("Ana Rodríguez");

        est.agregarNota(85.0);
        est.agregarNota(92.5);
        est.agregarNota(105.0); // Falla por superar 100
        est.agregarNota(78.0);
        
        est.mostrarResultado();
    }

    private static void probarClaseEmpleado() {
        System.out.println("--- 5. Pruebas Clase Empleado ---");

        Empleado emp1 = new Empleado("Luis Martínez", "Desarrollador Backend", 6500.00);
        Empleado emp2 = new Empleado("Sofía Hernández", "Diseñadora UX", 5800.00);
        
        System.out.println("Intentando asignar salario negativo a un empleado:");
        Empleado emp3 = new Empleado("Pedro Ruiz", "Pasante", -500.00);

        System.out.println("\n--- Registro de Empleados ---");
        emp1.mostrarDatos();
        emp2.mostrarDatos();
        emp3.mostrarDatos();
    }
}