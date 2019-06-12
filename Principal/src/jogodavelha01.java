/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
import java.util.Scanner;

public class jogodavelha { 
    
    public static void main(String[] args){
            int[][] matriz = new int[3][3];
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Matriz M[3][3]\n");
            
            for(int linha=0 ; linha < 3 ; linha++){
                for(int coluna = 0; coluna < 3 ; coluna ++){
                    System.out.printf("Insira o elemento M[%d][%d]: ",linha+1,coluna+1);
                    matriz[linha][coluna]=entrada.nextInt();
                }
            }
            
            System.out.println("\nA Matriz ficou: \n");
            for(int linha=0 ; linha < 3 ; linha++){
                for(int coluna = 0; coluna < 3 ; coluna ++){
                    System.out.printf("\t %d \t",matriz[linha][coluna]);
                }
                System.out.println();
            }
           
        }


}
