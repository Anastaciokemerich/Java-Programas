
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anastacio
 */
public class Arquivo_ex {

    public BufferedWriter brw;//objeto 
    public BufferedReader br;

    public void gravar() {
        try {
            brw = new BufferedWriter(new FileWriter("estadosARQ.txt")); //acrecentar conteudo em um arquivo("ARQ.txt,true)
            brw = write("tetsto a ser gravado:");//comando grava uma linha só
            brw.close();
           
        } catch (exception e) {
        }
    }

    private BufferedWriter write(String tetsto_a_ser_gravado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
