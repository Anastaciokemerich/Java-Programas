/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montadoraulaprogsistemas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usrlab09
 */
public class MontadorAulaProgSistemas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando o Montador...");
        Montador montador = new Montador();//Instancio o Montador
        //ABRIR ARQUIVO COM OS COMANDOS EM MNEMÃ”NICO
        montador.mostraRegistros();
        System.out.println("--------------------------------------------");
        try {
            BufferedReader br = new BufferedReader
            		(new FileReader("entrada"));
            FileWriter fw = new FileWriter("saida");
            PrintWriter pw = new PrintWriter(fw);
                while(br.ready()){
                Saida output;// = new Saida();
                String linha = br.readLine();
                System.out.println(linha);
                output = montador.setPalavra(linha);                
                pw.println(output.getComando()
                		+output.getPrimeiroP()
                		+output.getSegundoP());                
                System.out.println("--------------------------------------------");  
            }   
            pw.close();
            fw.close();
            br.close();//fecha o arquivo
        } catch (IOException ex) {
            ex.getMessage();
        }
                

                
    }
    
}
