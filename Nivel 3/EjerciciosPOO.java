import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ============================================================================
// 1. HERENCIA Y POLIMORFISMO (Animal, Perro, Gato)
// ============================================================================

class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método que será sobrescrito
    public void hacerSonido() {
        System.out.println(nombre + " (Animal) produce un sonido genérico.");
    }
}

class Perro extends Animal {
    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println("🐕 " + getNombre() + " (Perro " + raza + ") dice: ¡Guau! ¡Guau!");
    }
}

class Gato extends Animal {
    private String color;

    public Gato(String nombre, String color) {
        super(nombre);
        this.color = color;
    }

    @Override
    public void hacerSonido() {
        System.out.println("🐈 " + getNombre() + " (Gato " + color + ") dice: ¡Miau! ¡Miau!");
    }
}

// ============================================================================
// 2. ABSTRACCIÓN Y POLIMORFISMO DE FIGURAS (Figura, Cuadrado, Circulo)
// ============================================================================

// Clase Abstracta
abstract class Figura {
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto obligatorio
    public abstract double calcularArea();

    public void mostrarInformacion() {
        System.out.println("Figura: " + nombre + " | Área: " + String.format("%.2f", calcularArea()) + " u²");
    }
}

class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}

// ============================================================================
// 3. INTERFACES (Vehiculo, Carro, Moto)
// ============================================================================

interface Vehiculo {
    void encender();
    void acelerar(int velocidad);
    void frenar();
}

class Carro implements Vehiculo {
    private String marca;

    public Carro(String marca) {
        this.marca = marca;
    }

    @Override
    public void encender() {
        System.out.println("🚗 El carro " + marca + " ha encendido el motor con llave.");
    }

    @Override
    public void acelerar(int velocidad) {
        System.out.println("🚗 El carro " + marca + " acelera suavemente a " + velocidad + " km/h.");
    }

    @Override
    public void frenar() {
        System.out.println("🚗 El carro " + marca + " acciona los frenos de disco y se detiene.");
    }
}

class Moto implements Vehiculo {
    private String cilindrada;

    public Moto(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public void encender() {
        System.out.println("🏍️ La moto (" + cilindrada + ") enciende mediante pedal/botón.");
    }

    @Override
    public void acelerar(int velocidad) {
        System.out.println("🏍️ La moto (" + cilindrada + ") acelera con el manillar a " + velocidad + " km/h.");
    }

    @Override
    public void frenar() {
        System.out.println("🏍️ La moto (" + cilindrada + ") frena utilizando el freno de mano y pie.");
    }
}

// ============================================================================
// CLASE PRINCIPAL (Mismo nombre que tu archivo EjerciciosPOO.java)
// ============================================================================

public class EjerciciosPOO {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        do {
            mostrarMenu();
            try {
                System.out.print("\nSeleccione el módulo de POO Avanzada a probar (1-4) o 0 para salir: ");
                opcion = Integer.parseInt(scanner.nextLine());

                System.out.println("\n------------------------------------------------");
                switch (opcion) {
                    case 1 -> probarHerenciaYPolimorfismoAnimales();
                    case 2 -> probarAbstraccionYFiguras();
                    case 3 -> probarInterfacesVehiculos();
                    case 4 -> probarPolimorfismoIntegrado();
                    case 0 -> System.out.println("¡Finalizando laboratorio de POO Avanzada!");
                    default -> System.out.println("Opción no válida. Ingrese un número entre 0 y 4.");
                }
                System.out.println("------------------------------------------------\n");

            } catch (NumberFormatException e) {
                System.err.println("\nError: Debe ingresar un número entero válido.");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println("     LABORATORIO III - NIVEL 3 (POO AVANZADA)");
        System.out.println("==================================================");
        System.out.println("1. Herencia y Polimorfismo (Animal, Perro, Gato)");
        System.out.println("2. Abstracción y Cálculo de Áreas (Figura, Cuadrado, Círculo)");
        System.out.println("3. Interfaces y Comportamientos (Vehículo, Carro, Moto)");
        System.out.println("4. Integración Total con Listas Polimórficas");
        System.out.println("0. Salir");
        System.out.println("==================================================");
    }

    private static void probarHerenciaYPolimorfismoAnimales() {
        System.out.println("--- 1. Herencia y Polimorfismo (Animales) ---");
        
        List<Animal> granja = new ArrayList<>();
        granja.add(new Perro("Firulais", "Pastor Alemán"));
        granja.add(new Gato("Garfield", "Naranja"));
        granja.add(new Animal("Criatura Desconocida"));

        System.out.println("Recorriendo la lista de animales y ejecutando hacerSonido():");
        for (Animal a : granja) {
            a.hacerSonido();
        }
    }

    private static void probarAbstraccionYFiguras() {
        System.out.println("--- 2. Abstracción y Clases Abstractas (Figuras) ---");
        
        Figura f1 = new Cuadrado(5.0);
        Figura f2 = new Circulo(3.5);

        f1.mostrarInformacion();
        f2.mostrarInformacion();
    }

    private static void probarInterfacesVehiculos() {
        System.out.println("--- 3. Interfaces (Vehículos) ---");
        
        Vehiculo miCarro = new Carro("Toyota");
        Vehiculo miMoto = new Moto("250cc");

        System.out.println("Prueba de Carro:");
        miCarro.encender();
        miCarro.acelerar(80);
        miCarro.frenar();

        System.out.println("\nPrueba de Moto:");
        miMoto.encender();
        miMoto.acelerar(60);
        miMoto.frenar();
    }

    private static void probarPolimorfismoIntegrado() {
        System.out.println("--- 4. Cálculo Masivo de Áreas con Lista Polimórfica ---");

        List<Figura> listaFiguras = new ArrayList<>();
        listaFiguras.add(new Cuadrado(4));
        listaFiguras.add(new Circulo(2));
        listaFiguras.add(new Cuadrado(10));
        listaFiguras.add(new Circulo(5));

        double areaTotal = 0;
        for (Figura f : listaFiguras) {
            f.mostrarInformacion();
            areaTotal += f.calcularArea();
        }

        System.out.println("------------------------------------------------");
        System.out.println("Suma total de áreas calculadas: " + String.format("%.2f", areaTotal) + " u²");
    }
}