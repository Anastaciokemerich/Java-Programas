/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Anastacio
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    //public static void idade=30;
    public static void main(String[] args) {
        int vetor[] = new int[2];
        vetor[0]= 5;
        vetor[1]= 10;
        dobravaloreVetor(vetor));
        
        JOptionPane.showMessageDialog(null,"seu nome é "+exibeNome()+".");
        JOptionPane.showMessageDialog(null, "voce trabalha na "+trabalho());
        
    }

    /**
     *
     * @param v
     */
    public static void dobravaloreVetor(int[] v) {
        v[0] *=2;
        v[1] *=9;
        JOptionPane.showMessageDialog(null,  "vetor: "+Arrays.toString(v));
    }
    public static String exibeNome() {
        return "anastacio";
        
    }  
    public static String trabalho() {
        return "NET";
        
    }
    
}


    
  