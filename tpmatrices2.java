import java.util.Scanner;

public class tpmatrices2{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declaro la matriz
        char [][] estacionamiento  ;
        //declaro las variables
        int largo, ancho, opcion;

//define el ancho y el largo de la matriz con el scanner
        System.out.println("Ingrese el largo de la matriz: ");
        largo = sc.nextInt();
        System.out.println("Ingrese el ancho de la matriz: ");
        ancho = sc.nextInt();

//crea el arreglo de estacionamiento con el largo y el ancho ingresados
            estacionamiento = new char[largo][ancho];

            do { 
                System.out.println("Seleccione una opción:");
            System.out.println("1. Cargar matriz");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Contar lugares libres, ocupados y reservados");
            System.out.println("4. Buscar y ocupar el primer lugar libre");
            System.out.println("5. Salir");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> cargarMatriz(estacionamiento, sc);
                        
                    case 2 -> mostrarMatriz(estacionamiento);
                    case 3 -> contarLugares(estacionamiento);
                    case 4 -> buscarYOcuparPrimerLibre(estacionamiento);
                    case 5 -> System.out.println("Saliendo...");
                     // en caso de que el usuario ingrese una opción no válida, se muestra un mensaje de error
            default -> System.out.println("Opción no válida. Intente nuevamente.");
                        
                }
                
            } while (opcion != 5);

}

   //modulo para mostrar la matriz con formato de tabla
public static void mostrarMatriz(char[][] estacionamiento) {
        for (int i = 0; i < estacionamiento.length; i++) {
            System.out.print(" | ");
            for (int j = 0; j < estacionamiento[i].length; j++) {
                System.out.print(estacionamiento[i][j] + " | ");
            }
            System.out.println();
        }
    }

    //modulo para recorrer la matriz y contar los lugares libres, ocupados y reservados
    public static void contarLugares(char[][] estacionamiento) {
        int libres = 0, ocupados = 0, reservados = 0;
        for (int i = 0; i < estacionamiento.length; i++) {
            for (int j = 0; j < estacionamiento[i].length; j++) {
                switch (estacionamiento[i][j]) {
                    case 'L' -> libres++;
                    case 'O' -> ocupados++;
                    case 'R' -> reservados++;
                }
            }
        }
        System.out.println("Lugares libres: " + libres);
        System.out.println("Lugares ocupados: " + ocupados);
        System.out.println("Lugares reservados: " + reservados);
    }

    //modulo para buscar el primer lugar libre y marcarlo como ocupado
    public static void buscarYOcuparPrimerLibre(char[][] estacionamiento) {
        for (int i = 0; i < estacionamiento.length; i++) {
            for (int j = 0; j < estacionamiento[i].length; j++) {
                if (estacionamiento[i][j] == 'L') {
                    System.out.println("Primer lugar libre encontrado en la posición [" + i + "][" + j + "]");
                    estacionamiento[i][j] = 'O'; // marcar como ocupado
                    return; // salir del método una vez encontrado
                }
            }
        }
        System.out.println("No se encontró ningún lugar libre.");
    }

    //modulo para cargar los valores de la matriz 
    public static void cargarMatriz(char[][] estacionamiento, Scanner sc) {
        for (int i = 0; i < estacionamiento.length; i++) {
            for (int j = 0; j < estacionamiento[i].length; j++) {
                System.out.println("Ingrese la temperatura para la posición [" + i + "][" + j + "]: ");
                estacionamiento[i][j] = Character.toUpperCase(sc.next().charAt(0));
            }
        }
}
}