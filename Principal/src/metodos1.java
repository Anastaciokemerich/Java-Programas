/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
public class metodos1 {

    public static void main(String[] args) {
        System.out.println("curso:" + obterCurso() + " Duração:" + obterDuracao(4, "Anos :)."));
    }

    public static String obterCurso() {
       return "Ciencias Da Cumputaçã" ;
    }

   public static String obterDuracao(int i, String s){       
    return i+ " " +s ; 
    }

}
