package ex3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        try {
            //servidor cria um socket tcp do tipo servidor
            ServerSocket servidor = new ServerSocket(1234);
            //servidor aguarda uma conexão
            Socket cliente = servidor.accept(); //bloqueante
            System.out.println("Cliente conectado");

            //entrada de dados
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            //saída de dados
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            
            //thread para recebimento de mensagens
            new Thread() {
                public void run() {
                    try {
                        //recebimento de mensagem
                        while (true) {
                            String mensagemRecebida = dis.readUTF();
                            System.out.println("Recebi do cliente: " + mensagemRecebida);
                        }
                    } catch (Exception e) {

                    }
                }
            }.start();

            //a thread principal (main) fica enviando mensagens
            Scanner teclado = new Scanner(System.in);
            while (true) {
                String mensagemEnviar = teclado.nextLine();
                dos.writeUTF(mensagemEnviar);
            }

            //comunicação começa
        } catch (IOException ex) {
            System.out.println("Porta já em uso");
        }
    }
}
