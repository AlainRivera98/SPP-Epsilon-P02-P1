//Proyecto Parcial 2 
//Problema 1
//Equipo Epsilon
//Nombres, matrículas y carreras de integrantes de equipo:
//Roberto Alain Rivera Bravo | A01411516 | IMT11
//Fabricio Arturo Balboa Cavazos | A01411541 | IMT11
//Andrés de Jesús Martínez Castillo | A01411447 | IMT11
//Jessica Delgado González | A01411536 | IMT11
//Alfredo Alejandro Lárraga Sosa | A01410278 | LMC

/*
1.Con base en las actividades 9 y 10, desarrolla un programa que muestre un menú:
a.Suma de matrices
b.Resta de matrices
c.Multiplicación de matrices
Solicite al usuario el tamaño de la matriz cuadrada, su contenido y 
resuelva la opción elegida para después mostrar el resultado.
*/

package spp.epsilon.p02.p1;
import java.util.Scanner;

public class SPPEpsilonP02P1 {

    public static void main(String[] args) {
        boolean flag;
        
        do{        
            menu(); //manda a método menú
            flag = salida(); //recibe el valor booleano
        } while (flag==false);
    }
    
    
    //método menú: muestra las opciones en pantalla
    public static void menu(){
        int option;
        boolean flag;            
        
        System.out.println("----------------------------------");
        System.out.println("Operaciones con matrices cuadradas");
        System.out.println("----------------------------------");
        
        do {
            //Se elige una opción de operaciones de matrices
            System.out.println("Seleccione una opción");
            System.out.println("1. Suma de matrices");
            System.out.println("2. Resta de matrices");
            System.out.println("3. Multiplicacion de matrices");
            System.out.println("4. Salir");

            //variable que captura la opción elegida
            option = solicitarDatos();
            
            //estructura if/else para elegir opciones
            if(option >= 1  && option <= 3){
                crearMatrices(option);
                flag = true;
            } else if(option == 4){
                flag = true;
            }else{
                System.out.println("\nIntroduzca una opción válida\n");
                flag=false;   
            }
   
        } while (flag==false); 
        
    }
    
    
    /* método crear matrices: relaciona a los métodos para crear matrices, asignarles datos
    y realizar operaciones con ellas, según la opción que recibe del método menú*/
    public static void crearMatrices(int option){
        int m;
        int[][] matrix; // crea la matriz sobre la que se mostrara la respuesta de la operación realizada
        
        //Se asigna la dimensión de la matriz
        System.out.println("\nIntroduzca la dimensión de la matriz cuadrada");
        m = verificarIntPositivo();
        
        //Se asignan valores a la matriz A
        System.out.println("\nValores de matriz A");
        int[][]A = asignarValores(m);
        
        //Se asignan valores a la matriz B
        System.out.println("\nValores de matriz B");
        int[][]B = asignarValores(m);
        
        System.out.println("\n");
        matrix = new int[m][m]; //se asigna dimensión a la matriz que resultará de la opción elegida
        switch (option) { //Menú switch donde con la opción elegida se realiza una operación con las matrices

            case 1:
                //manda a método suma de matrices
                matrix = sumaDeMatrices(A,B,m);
                //se muestran los arrays
                System.out.println("La suma de la matriz A");
                mostrarArray(A);
                System.out.println("\ny la B");
                mostrarArray(B);
                System.out.println("\nes: ");
                mostrarArray(matrix);
                break;
                
            case 2:
                //manda a método resta de matrices
                matrix = restaDeMatrices(A,B,m);
                //se muestran los arrays
                System.out.println("La resta de la matriz A");
                mostrarArray(A);
                System.out.println("\ny la B");
                mostrarArray(B);
                System.out.println("\nes: ");
                mostrarArray(matrix);
                break; 
                
            case 3:
                //manda a método multiplicacion de matrices
                matrix = multiplicacionDeMatrices(A,B,m);
                //se muestran los arrays
                System.out.println("La multiplicacion de la matriz A");
                mostrarArray(A);
                System.out.println("\ny la B");
                mostrarArray(B);
                System.out.println("\nes: ");
                mostrarArray(matrix);
                break;
                
            default:
                break;
        }
     
    }
    
    //Método solicitar datos: permite verificar que los datos sean correctos y los captura
    public static int solicitarDatos(){
        Scanner teclado = new Scanner (System.in);
        int x=0;
        boolean flag;

        do {
            try { //Intenta realizar las instrucciones
                x = teclado.nextInt();
                flag = true;
            } catch (Exception ex) { //Evita que el programa falle en caso de error y muestra el error
                System.out.println("\nIntroduzca un número entero válido");
                System.out.println(ex);
                flag = false;
                teclado.next(); //Limpia el buffer del teclado
            }
     
        } while (flag == false);
        
        return x; //regresa el valor verificado
    }
    
    /*Método verificar int positivo: verifica que el entero sea positivo para evitar introducir
    valores negativos en el tamaño de la matriz*/
    public static int verificarIntPositivo(){
        boolean flag;
        int x;
        
        //Ciclo do while: ejecuta al menos una vez las instrucciones en do, y evalúa si es cierto en while
        do {
            x = solicitarDatos();
            //Evalúa si la x es menor a uno, y si lo es, asigna flag=false para repetir el ciclo
            if (x < 1) {
                System.out.println("Introduzca un entero positivo(no hay longitudes negativas o nulas de matrices)");
                flag=false;
            } else{
              flag=true;  
            }
            
        } while (flag==false);
    
        return x; //regresa el valor comprobado
    }    
    
    //Método asignar valores: asigna los valores de una matriz con un ciclo for
    public static int[][] asignarValores(int m){
        //Crea el array con el tamaño introducido por el usuario anteriormente
        int[][] matrix = new int[m][m];
        
        //Ciclo for: Nos desplaza en las filas del array
        for (int i = 0; i < m; i++) {
            //Ciclo for: Nos desplzaza en las columnas del array
            for (int j = 0; j < m; j++) {
                System.out.println("Introduzca el valor de la posición "+i+","+j);
                //Asigna el valor del array en la posición i, j
                matrix[i][j] = solicitarDatos();
            }
        }
 
        return matrix; //regresa la matriz a la que se le asignaron valores
    }
    
    //Método suma de matrices: regresa una matriz que es suma de otras 2 que llegan al método
    public static int[][] sumaDeMatrices(int[][]A, int[][]B, int m){
        
        int[][] S = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                S[i][j] = A[i][j] + B[i][j];
            }
        }

        return S; //regresa el array que es suma de las matrices
    }
    
    //Método suma de matrices: regresa una matriz que es resta de otras 2 que llegan al método
    public static int[][] restaDeMatrices(int[][]A, int[][]B, int m){
        
        int[][] R = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                R[i][j] = A[i][j] - B[i][j];
            }
        }
        return R; //regresa el array que es resta de las matrices
    }
    
    //Método multiplicación de matrices: regresa una matriz que es producto matricial de AXB
    public static int[][] multiplicacionDeMatrices(int[][]A, int[][]B, int m){
        int[][]M = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                /*Recorre los valores de columna en A y de fila en B para multiplicar
                cada elemento de la fila i de la matriz A por cada elemento de la columa j de la matriz B*/
                for (int k = 0; k < m; k++) {
                    M[i][j] += A[i][k]*B[k][j];
                }    
            }
        }
        
        return M; //regresa el array que es multiplicación de las matrices
    }
    
    //Método mostrar Array: muestra en pantalla la matriz creada
    public static void mostrarArray(int [][]matrix){ //Se recibe el objeto matrix
        //Recorre las "i" filass del array
        for(int i=0; i<matrix.length; i++){
            //Recorre las "j" columnas del array
            for (int j=0; j<matrix[i].length; j++){
                System.out.print("["+matrix[i][j]+"]");     
            }                
            /*Introduce un salto de línea cada que se rebase la cantidad de columnas del array
            para que se vea el arreglo en orden en pantalla*/
            System.out.println("\t");
        } 
        
    }
    
    //Método salir: da opción de terminar o reiniciar los cálculos   
    public static boolean salida(){
        Scanner teclado = new Scanner (System.in);
        String option;
        boolean flag;
        
        System.out.println("\n¿Desea salir?");
        System.out.println("SI: Presione 1");
        System.out.println("NO: Presione cualquier otra tecla");
        option = teclado.next();
        
        //verifica si el String es igual a "1"
        if(!option.equals("1")){
             //Se manda el valor booleano para volver a ejecutar el programa
            flag=false;
            System.out.println("\n\n");
        } else{
            //Se manda el valor booleano para terminar el programa
           flag=true; 
        }
        
        return flag;  //Se regresa el valor booleano
    }
    
    
}
