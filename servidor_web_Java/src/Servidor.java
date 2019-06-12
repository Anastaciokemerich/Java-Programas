
import java.io.*;
import java.net.*;

/**
 *
 * @author Anastacio
 */
public class Servidor {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //
        try {
            //servidor de socket
            ServerSocket servidor = new ServerSocket(1234);//porta 65045 portas
            System.out.println("Servidor Inicializado, Aguardando Conexões...");
            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Uma conexão foi estabelecida por:" + socket.getInetAddress());//fala que conectou no servidor
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                System.out.println("Mensagem recebida do cleinte:" + entrada.readUTF());
                //codigo a ser implemetado
                DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
                saida.writeUTF("Prezado cleinte ,sua menasagem foi recebida:");//resposta do msgrecebida
            }
        } catch (Exception e) {
        };

    }

}
