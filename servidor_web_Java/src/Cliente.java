
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
public class Cliente {    
     public static void main(String[] args) {
        // TODO code application 
         try {
             Socket socket = new Socket("10.20.75.1.99",1234);
             DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
             saida.writeUTF(" Anastacio ");
             DataInputStream entrada =new DataInputStream(socket.getInputStream());
             System.out.println("Resposta do servidor " +entrada.readUTF());
         }catch(Exception e){};        
    }
}
