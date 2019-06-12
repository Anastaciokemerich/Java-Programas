/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps_montador;

import java.io.IOException;

/**
 *
 * @author leonardo
 */
public class PS_montador {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here[
        montador mon = new montador();
        
        //mon.criar();
        
        //System.out.println("jau");
        
        String arquivo = mon.load();
        
        mon.montador(arquivo);
        
        mon.primeiropasso();
        
        mon.imprimir();
        
        System.out.println("\n");
        
        mon.imprimir_uso();
        
        System.out.println("\n");
        
        mon.imprimir_def();
        
        mon.segundopasso();
        
        System.out.println("\n");
        
        mon.imprimir2();
        
        //System.out.println(arquivo);
    }
    
}
