
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anastacio
 */
public class NewClass {

    public static void main(String[] args) {
        int vetor[];
        vetor = new int[10];
        for (int posição = 0; posição <= 9; posição++) {
            vetor[posição] = posição * posição;

        }
        exibeConteudoVetor(vetor);
    }

    /**
     *
     * @param v
     */
    @SuppressWarnings("empty-statement")
    public static void exibeConteudoVetor(int[] v ) {
        int i = 0;        
        for( i=0 ;i<=9 ;i++){   
        
    System.out.println("@" +Arrays.toString(v[i]);
        
    }
}
}
