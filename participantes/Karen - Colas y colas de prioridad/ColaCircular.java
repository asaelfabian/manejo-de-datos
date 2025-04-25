package colas;

public class ColaCircular {
    private int front, rear; // 'front' apunta al primer elemento, 'rear' al último elemento
    private int[] x; //Arreglo para almacenar los elementos de la cola

    //Constructor que recibe el tamaño de la cola
    ColaCircular(int size) {
        x = new int[size]; //Inicializa el arreglo con el tamaño especificado
        front = -1; // 'front = -1' indica que la cola está vacía
        rear = -1;  // 'rear = -1' también indica que la cola está vacía
    }

    //Constructor por defecto que crea una cola de tamaño 5
    ColaCircular() {
        this(5); //Llama al constructor que recibe el tamaño
    }

    //Método para encolar (insertar) un elemento en la cola
    void enqueue(int dato) {
        // Si la posición siguiente de 'rear' es igual a 'front', la cola está llena (condición de cola circular)
        if ((rear + 1) % x.length == front) { //si la cola esta llena
            System.out.println("Cola llena");
            return; //Sale del método sin insertar el valor
        }

        if (front == -1) { //Si la cola está vacía (no hay elementos)
            front = 0; //Inicializa 'front' en la posición 0
        }

        //Incrementa 'rear' de manera circular usando el operador módulo ('%') para que regrese al inicio si llega al final
        rear = (rear + 1) % x.length;
        x[rear] = dato; //Inserta el nuevo valor en la posición de 'rear'
    } //fin del encolado

    // Método para verificar si la cola está vacía
    boolean empty() {
        return front == -1; //La cola está vacía si 'front' es -1
    }

    //Método para desencolar (extraer) un elemento de la cola
    int dequeue() {
        if (empty()) { // Si la cola está vacía, muestra un mensaje de error
            System.out.println("Cola vacía");
            return -1; // Retorna -1 para indicar que no hay datos
        }

        int dato = x[front]; // Toma el valor del frente de la cola

        if (front == rear) {
            // Si solo hay un elemento en la cola (después de desencolar quedará vacía)
            front = -1; 
            rear = -1;
        } else {
            // Incrementa 'front' de manera circular usando el operador módulo (`%`)
            front = (front + 1) % x.length;
        }

        return dato; // Devuelve el valor extraído
    } //FIN DEL DESENCOLADO
} //FINN DE LA CLASE COLACIRCULAR







