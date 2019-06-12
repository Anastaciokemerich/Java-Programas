
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
public class Cliente implements Comunicação{
    
    
  public static void main(String[] args) {
        // TODO code application 
        Cliente cliente = new Cliente();
        cliente.enviaResposta("10.18.6.9", 5544,"213");
              
    }  

    @Override
    public void enviaResposta(String IPServidor, int portaServidor, String resposta) {
      try {
             Socket socket = new Socket(IPServidor,portaServidor);
             DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
             saida.writeUTF(resposta);
             DataInputStream entrada =new DataInputStream(socket.getInputStream());
             System.out.println("Resposta do servidor " +entrada.readUTF());
         }catch(Exception e){};     
    }
}
