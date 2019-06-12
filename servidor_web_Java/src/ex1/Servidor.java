package ex1;

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

                //entrada de dados
                DataInputStream dis = new DataInputStream(cliente.getInputStream());
                //saída de dados
                DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());

                //comunicação começa
                //recebe uma string
                String mensagem = dis.readUTF();//bloqueante
                System.out.println("Recebi " + mensagem);
                //se o cliente enviar "sair", quebra o laço, e consequentemente
                //mata o servidor
                if(mensagem.equals("sair")){
                    break;
                }
                //responde outra string
                String resposta = mensagem.toUpperCase();
                dos.writeUTF(resposta);
                cliente.close();
            }
        } catch (IOException ex) {
            System.out.println("Porta já em uso");
        }
    }
}
