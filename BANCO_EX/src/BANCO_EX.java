
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
public class BANCO_EX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\t BANCO KEMERICH");
        System.out.println("1. ABRIR CONTA CORRENTE");
        System.out.println("2. ABRIR CONTA POUPANÇA");
        System.out.println("3. DEPOSITAR CONTA CORRENTE");
        System.out.println("4. DEPOSITAR CONTA POUPANÇA");
        System.out.println("5. RETIRAR CONTA CORRENTE");
        System.out.println("6. RETIRAR CONTA POUPANÇA:");        
        System.out.println("21. EXIBIR CONTA CORRENTE:");        
        System.out.println("22. EXIBIR CONTA POUPANÇA:");
    }        
        
        public static void corrente(){
        System.out.println("ABRIR CONTA CORRENTE.");
    }
        do{
            menu();
            
            switch(opcao){
            case 1:
                corrente();
                break;
                
            case 2:
                poupança();
                break;
                
            case 3:
                exclui();
                break;
                
            case 4:
                consulta();
                break;
}
