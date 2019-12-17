/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author mmurillo
 */
public class Matrices {
    
    //Matrices de ejemplo para operaciones de matrices
    
    static int MatrizA [][] = { {1, 3, 5},
                         {5, 3, 2},
                         {9, 8, 1}
                        };
    
    static int MatrizB [][] = { {1, 2, 4},
                         {2, 8, 1},
                         {1, 5, 6}
                        };

    
    public static void main(String[] args) {
        
        
        System.out.println("MatrizA");
        imprimir(MatrizA);
        System.out.println("");
        System.out.println("MatrizB");
        imprimir(MatrizB);
        System.out.println("");
        System.out.println("Suma Matrices");
        imprimir(sumaMatrices());
        System.out.println("");
        System.out.println("Resta Matrices");
        imprimir(restaMatrices());
        System.out.println("");
        System.out.println("Multiplicar MatrizA numero");
        //adentro del parentesis se dice cual matriz y por cuanto multiplicar
        imprimir(multiNumMatrices(2, MatrizA));
        System.out.println("");
        System.out.println("Multiplicar MatrizB numero");
        imprimir(multiNumMatrices(2, MatrizB));
        System.out.println("");
        System.out.println("Multiplicar Matriz A y B");
        imprimir(multiMatrices());
        System.out.println("");
        System.out.println("Diagonal Secundaria A");
        imprimirArray(diagonalSecundaria(MatrizA));
        System.out.println("");
        System.out.println("Diagonal Principal A");
        imprimirArray(diagonalPrincipal(MatrizA));
        System.out.println("");
        
        
        
        
       
        /*if(matrizSuma==null){
            System.out.println("\nNo se puede realizar la suma de las matrices.");
        } else {
            System.out.println("\nMATRIZ SUMA");
            visualizar(matrizSuma);
        }*/
    }
    //para que devuelva una matriz
    public static int [][] sumaMatrices(){
        //Dadas dos o más matrices del mismo orden, el resultado de la suma es otra matriz 
        //del mismo orden cuyos elementos se obtienen como suma de los elementos colocados 
        //en el mismo lugar de las matrices sumandos.
        
        int filas1 = MatrizA.length;
        int col1 = MatrizA[0].length;
        int filas2 = MatrizB.length;
        int col2 = MatrizB[0].length;
     
          
        if(filas1 == filas2 && col1 == col2){
             int matrizSuma [][];
            matrizSuma = new int[filas1][col1];
            //tambien podria ser matriz b
            for(int i=0;i<MatrizA.length;i++){
                if (i /3==0){
                    
                }
                for(int j=0;j<MatrizA[0].length;j++){
                    matrizSuma[i][j] = MatrizA[i][j] + MatrizB[i][j];
                }
            }
            return matrizSuma;
        } else {
            //si no son del mismo tamano
            JOptionPane.showMessageDialog(null, "Las matrices no son del mismo tamano");
            return null;
        }
       
    }
    
    public static int [][] restaMatrices(){
        //Dadas dos o más matrices del mismo orden, el resultado de la resta es otra matriz 
        //del mismo orden cuyos elementos se obtienen como la resta de los elementos colocados 
        //en el mismo lugar de las matrices sumandos.
        
        int filas1 = MatrizA.length;
        int col1 = MatrizA[0].length;
        int filas2 = MatrizB.length;
        int col2 = MatrizB[0].length;
        int matrizResta [][] = new int [filas1][col1];
          
        if(filas1 == filas2 && col1 == col2){
            matrizResta = new int[filas1][col1];
            for(int i=0;i<MatrizA.length;i++){
                for(int j=0;j<MatrizA[0].length;j++){
                    matrizResta[i][j] = MatrizA[i][j] - MatrizB[i][j];
                }
            }
            return matrizResta;
        } else {
            //si no son del mismo tamano
            JOptionPane.showMessageDialog(null, "Las matrices no son del mismo tamano");
            return null;
        }
    }
    //entre paresntesis dice lo que recibe
    public static int [][] multiNumMatrices(int numMulti, int[][] matriz){
         //Para multiplicar una matriz cualquiera por un número real, se multiplican todos 
        //los elementos de la matriz por dicho número.
        
        int filas1 = matriz.length;
        int col1 = matriz[0].length;
        int matrizMulti [][] = new int [filas1][col1];

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0;  c < matriz[0].length; c++) {
                matrizMulti[f][c] = matriz[f][c] * numMulti;
            }
        }
        return matrizMulti;
        
    }
    //de aqui a abajo nno entra en el examen
    public static int [][] multiMatrices(){
        //Dos matrices A y B son multiplicables si el número de columnas de A 
        //coincide con el número de filas de B.
        
        //El elemento cij de la matriz producto se obtiene multiplicando cada elemento 
        //de la fila i de la matriz A por cada elemento de la columna j de la matriz B y sumándolos.
       
        int filas1 = MatrizA.length;
        int col1 = MatrizA[0].length;
        int filas2 = MatrizB.length;
        int col2 = MatrizB[0].length;
        int matrizMulti [][] = new int [filas1][col1];
          
        if(filas1 == filas2 && col1 == col2){
            matrizMulti = new int[filas1][col1];
            for (int x = 0; x < matrizMulti.length; x++) {
                for (int y = 0; y < matrizMulti[x].length; y++) {
                    for (int z = 0; z < col1; z++) {
                        matrizMulti[x][y] += MatrizA[x][z] * MatrizB[z][y];
                    }
                }
            }
            return matrizMulti;
        } else {
            //si no son del mismo tamano
            JOptionPane.showMessageDialog(null, "Las matrices no son del mismo tamano");
            return null;
        }
    }
    
    public static int[] diagonalPrincipal(int matriz[][]){
        
        int[] diagoPrincipal = new int[matriz.length];
                 
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                if(i==j){
                    diagoPrincipal[i] = matriz[i][j];
                }
            }
        }
        
        return diagoPrincipal;
    }
    
    public static int[] diagonalSecundaria(int matriz [][]){
        
        int[] diagoSecundaria = new int[matriz.length];
                 
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){

                if(i+j == matriz.length-1){
                    diagoSecundaria[i] = matriz[i][j];
                }
            }
        }
        
        return diagoSecundaria;
    }
    //imprime cualquier matriz que uno ponga para no tener que hacer uno para cada resultado
    public static void imprimir(int[][] matrizImprimir){
        for(int f=0;f<matrizImprimir.length;f++){
            for(int c=0;c<matrizImprimir[f].length;c++){
                System.out.print(matrizImprimir[f][c] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void imprimirArray(int[] arrayImprimir){
        for(int f=0;f<arrayImprimir.length;f++){
           
                System.out.print(arrayImprimir[f] + " ");
        }
    }
    

    
    
}

