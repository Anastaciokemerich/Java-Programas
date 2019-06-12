
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
public class metodos {

    public static void main(String[] args) {
        exibirMessagem("reiner");
        System.out.println("hoje é dia "+exibirDia());
        System.out.println("A data completa " +exibirDataCompleta(3)); 
    }

    public static void exibirMessagem(String nome) {
        System.out.println("bem-vindo ou sistema "+nome);
    }

    public static int exibirDia() {
        return 24;
    }
    public static String exibirDataCompleta(int mes) {
        return "24/" + mes + "/2017";
    }

}
