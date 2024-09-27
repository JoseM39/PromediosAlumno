import java.util.Scanner;

public class Actividad3 {
    //Atributos
    private String nombre;
    private int[] calificaciones; //Array

    //Constructor
    public Actividad3(String nombre, int[] calificaciones) {
        this.nombre = nombre; //Referenciamos los atributos
        this.calificaciones = calificaciones;
    }

    //Metodo para calcular el promedio de las cinco calificaciones
    public double getPromedio() {
        int suma = 0;
        for (int calificacion : calificaciones) { //bucle for-each
            suma += calificacion; //calificacion se suma
        }
        return suma / 5.0; //regresamos el valor de suma entre 5.0
    }

    // Metodo para obtener la calificación final basado en el promedio
    public char getCalificacionFinal(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Metodo para mostrar el resultado
    public void mostrarResultado() {
        double promedio = getPromedio();
        char calificacionFinal = getCalificacionFinal(promedio);
        System.out.println("\nAlumno: " + nombre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación Final: " + calificacionFinal);
    }

    //Main del programa
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int[] calificaciones = new int[5];
        String nombre;
        int R;

        System.out.println("\nPrograma para calcular el promedio del alumno.");
        System.out.println("Nota: Las calificaciones van del 10 al 100.");

        do {
            System.out.print("\nIngrese el nombre del alumno: ");
            nombre = Input.nextLine(); //Se lee el nombre del alumno

            //Pedir las calificaciones
            for (int i = 0; i < 5; i++) {
                System.out.print("Ingrese la calificacion " + (i + 1) + ": ");
                calificaciones[i] = Input.nextInt();

                if (calificaciones [i] < 10 || calificaciones [i] > 100 ) { //Nos aseguramos de que la califacion este entre 10 y 100
                    System.out.println("Ingrese una nota valida.\n");
                    i--;
                }
            }

            Actividad3 alumno = new Actividad3(nombre, calificaciones); //Creamos un objeto de la clase
            alumno.mostrarResultado();

            //Pregunta si desea continuar
            System.out.print("\n¿Desea calcular el promedio de otro alumno? 1.Si 2.No: ");
            R = Input.nextInt();

            //Consume el salto de linea sobrante
            Input.nextLine(); //Esto evita que se salte la lectura del nombre en el siguiente ciclo
        }while (R!=2);
    }
}