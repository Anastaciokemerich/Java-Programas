package ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        try {
            //servidor cria um socket tcp do tipo servidor
            ServerSocket servidor = new ServerSocket(1234);
            while (true) {
                //servidor aguarda uma conexão
                Socket cliente = servidor.accept(); //bloqueante
                System.out.println("Cliente conectado");

                new Thread() {
                    public void run() {
                        try {
                            //entrada de dados
                            DataInputStream dis = new DataInputStream(cliente.getInputStream());
                            String ipCliente = cliente.getInetAddress().getHostAddress();

                            //comunicação começa
                            while (true) {
                                String mensagem = dis.readUTF();//bloqueante
                                System.out.println("Recebi do ip " + ipCliente + ":" + mensagem);
                            }
                        } catch (Exception e) {

                        }
                    }
                }.start();

            }
        } catch (IOException ex) {
            System.out.println("Porta já em uso");
        }
    }
}
