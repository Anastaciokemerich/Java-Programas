package ex2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            //criar um socket cliente para se conectar
            Socket cliente = new Socket("10.2.75.199", 1234);
            System.out.println("Cliente conectado");
            
            //saída de dados
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            
            //comunicação começa
            Scanner teclado = new Scanner(System.in);
            while(true){
                String mensagem = teclado.nextLine();
                dos.writeUTF(mensagem);
            }
        } catch (IOException ex) {
            System.out.println("Servidor não encontrado");
        }
    }
}
