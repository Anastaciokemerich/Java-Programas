package ex1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        try {
            //criar um socket cliente para se conectar
            Socket cliente = new Socket("172.25.0.161", 1234);
            System.out.println("Cliente conectado");
            
            //entrada de dados
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            //saída de dados
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            
            //comunicação começa
            //envia uma string para o servidor
            dos.writeUTF("sair");
            //espera a resposta do servidor
            String resposta = dis.readUTF();//bloqueante
            System.out.println("Recebi do servidor: "+resposta);
        } catch (IOException ex) {
            System.out.println("Servidor não encontrado");
        }
    }
}
