
import java.util.Scanner;

public class tpMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //declaro la matriz
        int [][] temperaturas  ;
        //declaro las variables
        int largo, ancho, opcion;

//define el ancho y el largo de la matriz con el scanner
        System.out.println("Ingrese el largo de la matriz: ");
        largo = sc.nextInt();
        System.out.println("Ingrese el ancho de la matriz: ");
        ancho = sc.nextInt();

//crea el arreglo de temperaturas con el largo y el ancho ingresados
            temperaturas = new int[largo][ancho];

        /*= {
            {30, 32, 31, 29},
            {28, 35, 33, 30},
            {27, 29, 36, 34},
            {26, 28, 30, 31}
        } ; */

        //usando la estructura do-while para mostrar el menú y ejecutar las opciones hasta que el usuario decida salir
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Cargar matriz");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Temperatura máxima");
            System.out.println("4. Temperatura mínima");
            System.out.println("5. Temperatura promedio");
            System.out.println("6. Cantidad de temperaturas mayores a una temperatura X");
            System.out.println("7. Puntos calientes");
            System.out.println("8. Salir");
//lee la opción ingresada por el usuario
            opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> cargarMatriz(temperaturas, sc);
            case 2 -> mostrarMatriz(temperaturas);
            case 3 -> temperaturaMaxima(temperaturas);
            case 4 -> temperaturaMinima(temperaturas);
            case 5 -> temperaturaPromedio(temperaturas);
            case 6 -> temperaturaMayor(temperaturas, sc);
            case 7 -> puntosCalientes(temperaturas);
            case 8 -> System.out.println("Saliendo...");
            // en caso de que el usuario ingrese una opción no válida, se muestra un mensaje de error
            default -> System.out.println("Opción no válida. Intente nuevamente.");
        }
} while (opcion != 8);
        
    }
        
    
    //modulo para mostrar la matriz con formato de tabla
public static void mostrarMatriz(int[][] temperaturas) {
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print(" | ");
            for (int j = 0; j < temperaturas[i].length; j++) {
                System.out.print(temperaturas[i][j] + " | ");
            }
            System.out.println();
        }
    }

    //modulo para cargar los valores de la matriz 
    public static void cargarMatriz(int[][] temperaturas, Scanner sc) {
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                System.out.println("Ingrese la temperatura para la posición [" + i + "][" + j + "]: ");
                temperaturas[i][j] = sc.nextInt();
            }
        }
}

//modulo para calcular la temperatura máxima recorriendo toda la matriz
public static void temperaturaMaxima(int [][] temperaturas) {
    int max = temperaturas[0][0];
    for (int i = 0; i < temperaturas.length; i++) {
        for (int j = 0; j < temperaturas[i].length; j++) {
            if (temperaturas[i][j] > max) {
                max = temperaturas[i][j];
            }
        }
    }
    System.out.println("La temperatura máxima es: " + max);

    
}
//modulo para calcular la temperatura mínima recorriendo toda la matriz
public static void temperaturaMinima(int [][] temperaturas) {
    int min = temperaturas[0][0];
    for (int i = 0; i < temperaturas.length; i++) {
        for (int j = 0; j < temperaturas[i].length; j++) {
            if (temperaturas[i][j] < min) {
                min = temperaturas[i][j];
            }
        }
    }
    System.out.println("La temperatura mínima es: " + min);
}
//modulo para calcular la temperatura promedio recorriendo toda la matriz
public static void temperaturaPromedio(int [][] temperaturas) {
    int sum = 0;
    int count = 0;
    for (int i = 0; i < temperaturas.length; i++) {
        for (int j = 0; j < temperaturas[i].length; j++) {
            sum += temperaturas[i][j];
            count++;
        }
    }
    double promedio = (double) sum / count;
    System.out.println("La temperatura promedio es: " + promedio);
} 

//modulo para calcular la cantidad de temperaturas mayores a una temperatura X ingresada por el usuario recorriendo toda la matriz
public static void temperaturaMayor(int [][] temperaturas, Scanner sc) {
    System.out.println("ingrese la temperatura a comparar: ");
    int temperaturaX = sc.nextInt();
    int cantidadTemperaturas = 0;
    for (int i = 0; i < temperaturas.length; i++) {
        for (int j = 0; j < temperaturas[i].length; j++) {
            if (temperaturas[i][j] > temperaturaX) {
                cantidadTemperaturas++;
            }
        }
    }
    System.out.println("La cantidad de temperaturas mayores a " + temperaturaX + " es: " + cantidadTemperaturas);
}

/*modulo para encontrar los puntos calientes, es decir, aquellos valores 
que son mayores a sus vecinos inmediatos (arriba, abajo, izquierda y derecha) 
recorriendo toda la matriz*/
public static void puntosCalientes(int [][] temperaturas) {
    if (temperaturas.length < 3 || temperaturas[0].length < 3) {
    System.out.println("La matriz es demasiado pequeña para buscar puntos calientes.");
    return;
}
   for (int i = 1; i < temperaturas.length - 1; i++) {
        for (int j = 1; j < temperaturas[i].length - 1; j++) {
            if (temperaturas[i][j] > temperaturas[i-1][j] && temperaturas[i][j] > temperaturas[i+1][j]
                    && temperaturas[i][j] > temperaturas[i][j-1] && temperaturas[i][j] > temperaturas[i][j+1]) {
                
                System.out.println("Punto caliente encontrado en la posición [" + i + "][" + j + "] con valor: " + temperaturas[i][j]);
            }
        }
        System.out.println("No se encontraron puntos calientes en la matriz.");
    }
}
}
