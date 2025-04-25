package colas;

public class ColaLineal {
    int front, rear; // front indica el frente de la cola, rear indica el final de la cola
    private int[] x; //Arreglo para almacenar los elementos de la cola
    
    //Creamos constructores para que reciba el tamaño de la cola
    ColaLineal(int tam){
        x = new int[tam]; //Inicializa el arreglo con el tamaño especificado
        front = 0;  //Inicializa front en 0, que apunta al primer elemento
        rear = -1;  //Inicializa rear en -1, lo que indica que la cola está vacía
    }
    
    //Constructor por defecto que crea una cola de tamaño 6 (tamaño fijo de la cola)
    ColaLineal() {
        this(6); //Llama al constructor que recibe el tamaño
    }
    
    //Método para encolar (insertar) un elemento en la cola
    void enqueue(int dato) {
        if (rear < x.length - 1) { //Verifica si hay espacio en la cola
            rear++; //Incrementa el índice del final de la cola
            x[rear] = dato; //Inserta el nuevo dato en la posición rear
        } //fin del if
        else {
            System.out.println("Cola llena"); // Si la cola está llena, muestra un mensaje de error
        } //fin del else
    } //fin del encolado

    //Método para verificar si la cola está vacía
    boolean empty() { //boolean para usar TRUE y FALSE
        if (rear < front) // Si rear es menor que front, la cola está vacía
            return true;
        else
            return false;
    } //fin del empty

    //Método para desencolar (extraer) un elemento de la cola
    int dequeue() {
        int dato = -1; //Valor por defecto si la cola está vacía
        if (empty()) { //Si la cola está vacía, muestra un mensaje de error
            System.out.println("Cola vacía");
        } else {
            dato = x[front]; // Toma el valor del frente de la cola
            front++; //Mueve el índice del frente al siguiente elemento
        } //fin del else 
        return dato; //Devuelve el valor extraído
    } //fin del desencolar
} //fin de la clase ColaLineal