
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anastacio
 */
public class soma30 {

    public static void main(String[] args) {
//ler um numero e fazer a soma dos 30 numeros proximos pares
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe umm numero"));
        
        if(numero % 2 == 1) {
            numero++;
        }
        
        int soma = 0;
        //for de numero indicado ate os 60 interaçoes da soma
        for (int i = numero; i < numero + 60; i++) {
            if (i % 2 == 0) {
                //if (i > 2) {
                soma = soma + i;
                System.out.println(i + " " +  soma);

            }
        }
        // mostra os numeros somados
        JOptionPane.showMessageDialog(null, "Soma dos pares é: " + soma);
    }

}
