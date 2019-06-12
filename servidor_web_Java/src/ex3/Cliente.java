package ex3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            //criar um socket cliente para se conectar
            Socket cliente = new Socket("10.20.75.199", 1234);
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
                            System.out.println("Recebi do servidor: " + mensagemRecebida);
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
            
        } catch (IOException ex) {
            System.out.println("Servidor não encontrado");
        }
    }
}
