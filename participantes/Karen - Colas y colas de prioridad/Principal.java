package colas;
import java.util.Scanner; //Importa la clase Scanner para la entrada de datos

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Crea un objeto Scanner para leer datos desde la consola

        //Solicitar al usuario el tamaño de la cola
        System.out.print("Ingrese el tamaño de las colas: ");
        int tam = scanner.nextInt(); //Lee el tamaño ingresado por el usuario

        // Crear instancias de las dos clases de colas con el tamaño dado por el usuario
        ColaLineal colaLineal = new ColaLineal(tam); // Cola lineal con tamaño definido por el usuario
        ColaCircular colaCircular = new ColaCircular(tam); // Cola circular con tamaño definido por el usuario

        //Ciclo for para encolar valores en la ColaLineal
        System.out.println("\n--- Encolando en Cola Lineal ---");
        for (int i = 0; i < tam; i++) {
            colaLineal.enqueue(i + 1); //Inserta valores secuenciales (1, 2, 3, ...) en la cola lineal
        }

        //Ciclo for para desencolar valores de la ColaLineal
        System.out.println("\n--- Desencolando de Cola Lineal ---");
        for (int i = 0; i < tam; i++) {       
            System.out.println(colaLineal.dequeue()); //Extrae y muestra los valores en el orden de entrada
        }

        // Ciclo for para encolar valores en la ColaCircular
        // Intenta encolar 10 elementos aunque el tamaño de la cola puede ser menor
        System.out.println("\n--- Encolando de Cola Circular ---");
        for (int i = 0; i < 10; i++) {
            colaCircular.enqueue(i + 1); // Inserta valores secuenciales en la cola circular
        } 

        // Ciclo for para desencolar valores de la ColaCircular
        // Intenta desencolar 10 elementos (si están disponibles)
        System.out.println("\n--- Desencolando de Cola Circular ---");
        for (int i = 0; i < 10; i++) {       
            System.out.println(colaCircular.dequeue()); // Extrae y muestra los valores en el orden de entrada
        } 

        scanner.close(); //Cierra el objeto Scanner para liberar recursos
} //fin del main
} //fin de la clase principal



