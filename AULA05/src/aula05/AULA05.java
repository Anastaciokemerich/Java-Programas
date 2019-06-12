/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula05;

import javax.swing.JOptionPane;

/**
 *
 * @author Anastacio
 */
public class AULA05 {
JOptionPane.showMessageDialog(null, "-Escolha uma opção- +. Soma  -. Subtracao  *. Multiplicacao  /. Divisao 0. sair");
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("BEM VINDOS AO SISTEMAS");
        //exibirMensagem("unifra", 17);
        //retorno.....  
        //String msg;
        //msg = exibirMensagem("unifra", 17);
        System.out.println(exibirMensagem( "unifra", 17));
    }

    public static String exibirMensagem(String nomeIES, int dia) {
        System.out.println("santa maria ,17 de março de 2017"  + nomeIES);
        return ("menssagen exibida");
    }
