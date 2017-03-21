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
            menu();
            flag = salida();
        } while (flag==false);
    }
    
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

            option = solicitarDatos();
            
            if(option >=1  && option <= 3){
                crearMatrices(option);
                flag = true;
            } else if(option == 4){
                flag = true;
            }else{
                System.out.println("Introduzca una opción válida");
                flag=false;   
            }
   
        } while (flag==false); 
        
    }
    
    
    public static void crearMatrices(int option){
        int m;
        int[][] matrix;
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
        matrix = new int[m][m];
        switch (option) { //Menú switch donde con la opción elegida se realiza una operación con las matrices

            case 1:
                //manda a método suma de matrices
                matrix = sumaDeMatrices(A,B,m);
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
    
    public static int solicitarDatos(){
        Scanner teclado = new Scanner (System.in);
        int x=0;
        boolean flag;

        do {
            try {
                x = teclado.nextInt();
                flag = true;
            } catch (Exception ex) {
                System.out.println("\nIntroduzca un número entero válido");
                System.out.println(ex);
                flag = false;
                teclado.next();
            }
     
        } while (flag == false);
        
        return x;
    }
    
    public static int verificarIntPositivo(){
        boolean flag;
        int x;
        
        do {
            x = solicitarDatos();
            if (x<1) {
                System.out.println("Introduzca un entero positivo válido");
                flag=false;
            } else{
              flag=true;  
            }
            
        } while (flag==false);
    
        return x;
    }    
    
    public static int[][] asignarValores(int m){
        int[][] matrix = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Introduzca el valor de la posición "+i+","+j);
                matrix[i][j] = solicitarDatos();
            }
        }
 
        return matrix;
    }
    
    public static int[][] sumaDeMatrices(int[][]A, int[][]B, int m){
        
        int[][] S = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                S[i][j] = A[i][j] + B[i][j];
            }
        }

        return S;
    }
    
    public static int[][] restaDeMatrices(int[][]A, int[][]B, int m){
        
        int[][] R = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                R[i][j] = A[i][j] - B[i][j];
            }
        }
        return R;
    }
    
    public static int[][] multiplicacionDeMatrices(int[][]A, int[][]B, int m){
        int[][]M = new int[m][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    M[i][j] += A[i][k]*B[k][j];
                }    
            }
        }
        
        return M;
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
